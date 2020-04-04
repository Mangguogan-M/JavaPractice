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
		测试图书的入库出库操作();

	}
	
	public static void 测试图书的入库出库操作() {
		Scanner input = new Scanner(System.in);
		BookInfoBiz bookInfoBiz = new BookInfoBizImplV1();
		
		//增加书籍
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn("123-456");
		bookInfo.setName("三生三世");
		for(int i = 0; i < 5; i++) {
			Book book = new Book();
			book.setBookId((i + 1) + "");
			book.setIsbn("123-456");
			bookInfo.addBook(book);
		}
		Map<String, BookInfo> infoMap = new HashMap<>();
		infoMap.put(bookInfo.getIsbn(), bookInfo);
		FileUtil.SaveBookInfoMap(infoMap);
		
		System.out.println("扫描要入库的图书出版号：");
		String isbn = input.next();
		boolean isInStoreSuccess = bookInfoBiz.inStore(isbn, 15);
		System.out.println("入库是否成功：" + isInStoreSuccess);
		BookInfo currBookInfo = bookInfoBiz.findByIsbn(isbn);
		System.out.println("当前库存：" + currBookInfo.getInStoreCount());
		
//		boolean isOutStoreSuccess = bookInfoBiz.outStore(isbn, 16);
//		currBookInfo = bookInfoBiz.findByIsbn(isbn);
//		System.out.println("出库是否成功：" + isOutStoreSuccess);
//		System.out.println("当前库存：" + currBookInfo.getInStoreCount());
	}
	
	
	public static void 测试图书实体类的定义() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn("123-456");
		bookInfo.setName("三生三世");
		Book book = new Book();
		book.setIsbn("123-456");
		bookInfo.addBook(book);
		
		Map<String, BookInfo> infoMap = new HashMap<>();
		infoMap.put(bookInfo.getIsbn(), bookInfo);
		FileUtil.SaveBookInfoMap(infoMap);
		System.out.println(book.getBookInfo().getName());
		
		infoMap = FileUtil.ReadBookInfoMap();
		System.out.println("从文件中读取的图书信息：");
		for(String isbn : infoMap.keySet()) {
			System.out.println(isbn);
		}
	}

}
