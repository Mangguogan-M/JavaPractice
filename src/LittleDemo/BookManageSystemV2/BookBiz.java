package LittleDemo.BookManageSystemV2;

import java.util.Iterator;

/**
 * ͼ���ҵ���ࡪ�� ������ͼ��Ļ�������
 * @author ����
 *
 */
public class BookBiz {	
	
	//��ʼ��д�����Ĳ���
	//����ͼ�顢���⡢��⡢��ѯ������
	
	public int getBookCount() {
		int count = 0;
		for(Book book : Datas.BookStore) {
			if(book == null) break;
			count++;
		}
		return count;
	}
	
	public int getBookCount(Book ...books) {
		int count = 0;
		for(Book book : books) {
			if(book == null) break;
			count++;
		}
		return count;
	}
	
	/**
	 * ���ӷ���
	 * @param book
	 * @return
	 */
	public boolean addBook(Book book) {
		int bookCount = getBookCount();
		if(Datas.BookStore.length == bookCount) {
			return false;
		}
		//����ֿⲻ�����Ͱ�ͼ��ŵ�������
		Datas.BookStore[bookCount] = book;
		return true;
	}
	
	/**
	 * ɾ�������ͼ�����
	 * @param book
	 * @return
	 */
	public boolean delBook(Book book) {
		int bookCount = getBookCount();
		int delIndex = -1;
		for (int i = 0; i < bookCount; i++) {
			//if (book.getBookId().equals(Datas.BookStore[i].getBookId())) {
			if (book.equals(Datas.BookStore[i])) {
				delIndex = i;
				break;
			}		
		}
		if (delIndex == -1) {
			return false;
		}
		//ɾ��
		for (int i = delIndex; i < bookCount; i++) {
			Datas.BookStore[i] = Datas.BookStore[i + 1];
		}
		Datas.BookStore[bookCount - 1] = null;
		return true;
	}
	
	
	
	/**
	 * ���ҷ���
	 */
	public Book findById(String bookId) {
		int bookCount = getBookCount();
		for (int i = 0; i < bookCount; i++) {
			if (bookId.equals(Datas.BookStore[i].getBookId())) {
				return Datas.BookStore[i];
			}
		}
		return null;
	}
	
	/**
	 * ���
	 */
	public boolean inStore(String bookId, int count) {
		Book book = findById(bookId);
		if (null == book) {
			return false;
		}
		book.setCount(book.getCount() + count);
		return true;
	}
	
	/**(
	 * ����
	 */
	public boolean outStore(String bookId, int count) {
		Book book = findById(bookId);
		if (null == book) {
			return false;
		}
		if (book.getCount() < count) {
			return false;
		}
		book.setCount(book.getCount() - count);
		return true;
	}
}





















