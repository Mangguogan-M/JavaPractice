package LittleDemo.BookSystem.entity;

import java.io.Serializable;

/**
 * 真是的图书对象
 * @author 马坤
 *
 */
public class Book implements Serializable{
	private static final long serialVersionUID = 9086804585467380173L;
	private String isbn;
	private String bookId;		//图书馆中内部编号
	//private  isCanBorrow;
	private BookState state;
	private BookInfo bookInfo;
	
	@Override
	public boolean equals(Object obj) {
		if(null == obj) return false;
		if(!(obj instanceof Book)) return false;
		Book book = (Book)obj;
		return bookId.equals(book.getBookId());
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public BookState getState() {
		return state;
	}
	public void setState(BookState state) {
		this.state = state;
	}
	public BookInfo getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}
}
/**
 * 图书的状态
 * @author 马坤
 *
 */
enum BookState{
	可借,不可借,缺货,损坏,维修中
}
