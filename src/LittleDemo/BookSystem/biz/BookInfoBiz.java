package LittleDemo.BookSystem.biz;

import LittleDemo.BookSystem.entity.BookInfo;

public interface BookInfoBiz extends Biz<BookInfo>{
	
	public BookInfo findByIsbn(String isbn);
	
	public boolean outStore(String isbn, int outCount);
	
	public boolean inStore(String isbn, int inCount);
}
