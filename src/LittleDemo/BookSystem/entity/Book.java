package LittleDemo.BookSystem.entity;

import java.io.Serializable;

/**
 * ���ǵ�ͼ�����
 * @author ����
 *
 */
public class Book implements Serializable{
	private static final long serialVersionUID = 9086804585467380173L;
	private String isbn;
	private String bookId;		//ͼ������ڲ����
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
 * ͼ���״̬
 * @author ����
 *
 */
enum BookState{
	�ɽ�,���ɽ�,ȱ��,��,ά����
}
