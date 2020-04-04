package LittleDemo.BookManageSystemV2;

import java.util.Iterator;

/**
 * 图书的业务类—— 包括对图书的基本操作
 * @author 马坤
 *
 */
public class BookBiz {	
	
	//开始书写基本的操作
	//增加图书、出库、入库、查询、排序
	
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
	 * 增加方法
	 * @param book
	 * @return
	 */
	public boolean addBook(Book book) {
		int bookCount = getBookCount();
		if(Datas.BookStore.length == bookCount) {
			return false;
		}
		//如果仓库不满，就把图书放到数组中
		Datas.BookStore[bookCount] = book;
		return true;
	}
	
	/**
	 * 删除传入的图书对象
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
		//删除
		for (int i = delIndex; i < bookCount; i++) {
			Datas.BookStore[i] = Datas.BookStore[i + 1];
		}
		Datas.BookStore[bookCount - 1] = null;
		return true;
	}
	
	
	
	/**
	 * 查找方法
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
	 * 入库
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
	 * 出库
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





















