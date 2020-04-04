package LittleDemo.BookManageSystemV2;

/**
 * 图书实体类
 * 
 * @author 马坤
 *
 */
public class Book {
	private String bookId; // 图书的内部编号
	private String bookName; // 图书的名称
	private String isdn; // 出版号
	private String type; // 数据的类型
	private String auther; // 作者
	private String publisher; // 出版社
	private int count; // 书记的库存量
	private double price; // 单价

	public Book() {

	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj || !(obj instanceof Book)) {
			return false;
		}
		Book book = (Book) obj;
		return bookId.equals(book.getBookId());
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getIsdn() {
		return isdn;
	}

	public void setIsdn(String isdn) {
		this.isdn = isdn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
