package LittleDemo.BookSystem.text;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import LittleDemo.BookSystem.biz.BookInfoBizImplV1;
import LittleDemo.BookSystem.util.FileUtil;
import LittleDemo.BookSystem.biz.BookInfoBiz;
import LittleDemo.BookSystem.entity.Book;
import LittleDemo.BookSystem.entity.BookInfo;

public class BookText {

	public static void main(String[] args) {
		����ͼ������������();

	}
	
	public static void ����ͼ������������() {
		Scanner input = new Scanner(System.in);
		BookInfoBiz bookInfoBiz = new BookInfoBizImplV1();
		
		//�����鼮
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn("123-456");
		bookInfo.setName("��������");
		for(int i = 0; i < 5; i++) {
			Book book = new Book();
			book.setBookId((i + 1) + "");
			book.setIsbn("123-456");
			bookInfo.addBook(book);
		}
		Map<String, BookInfo> infoMap = new HashMap<>();
		infoMap.put(bookInfo.getIsbn(), bookInfo);
		FileUtil.SaveBookInfoMap(infoMap);
		
		System.out.println("ɨ��Ҫ����ͼ�����ţ�");
		String isbn = input.next();
		boolean isInStoreSuccess = bookInfoBiz.inStore(isbn, 15);
		System.out.println("����Ƿ�ɹ���" + isInStoreSuccess);
		BookInfo currBookInfo = bookInfoBiz.findByIsbn(isbn);
		System.out.println("��ǰ��棺" + currBookInfo.getInStoreCount());
		
//		boolean isOutStoreSuccess = bookInfoBiz.outStore(isbn, 16);
//		currBookInfo = bookInfoBiz.findByIsbn(isbn);
//		System.out.println("�����Ƿ�ɹ���" + isOutStoreSuccess);
//		System.out.println("��ǰ��棺" + currBookInfo.getInStoreCount());
	}
	
	
	public static void ����ͼ��ʵ����Ķ���() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn("123-456");
		bookInfo.setName("��������");
		Book book = new Book();
		book.setIsbn("123-456");
		bookInfo.addBook(book);
		
		Map<String, BookInfo> infoMap = new HashMap<>();
		infoMap.put(bookInfo.getIsbn(), bookInfo);
		FileUtil.SaveBookInfoMap(infoMap);
		System.out.println(book.getBookInfo().getName());
		
		infoMap = FileUtil.ReadBookInfoMap();
		System.out.println("���ļ��ж�ȡ��ͼ����Ϣ��");
		for(String isbn : infoMap.keySet()) {
			System.out.println(isbn);
		}
	}

}
