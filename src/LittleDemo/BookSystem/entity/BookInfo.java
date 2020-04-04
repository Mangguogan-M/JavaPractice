package LittleDemo.BookSystem.entity;
/**
 * 
 * @author 马坤
 *
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

public class BookInfo implements Serializable{
	private static final long serialVersionUID = -7396486324501800343L;
	private String isbn;
	private String name;
	private String type;		//可以从配置文件中获得/
	private String author;
	private String publisher;
	private int inStoreCount;
	private Data publishData;
	private double price;
	
	private List<Book> bookList;
	
	
	public void addBook(Book book) {
		if (null == bookList) {
			bookList = new ArrayList<>();
		}
		if(null == book) return;
		if(!isbn.equals(book.getIsbn())) return;
		if(bookList.contains(book)) return;
		book.setBookInfo(this);
		bookList.add(book);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getInStoreCount() {
		return inStoreCount;
	}
	public void setInStoreCount(int inStoreCount) {
		this.inStoreCount = inStoreCount;
	}
	public Data getPublishData() {
		return publishData;
	}
	public void setPublishData(Data publishData) {
		this.publishData = publishData;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
