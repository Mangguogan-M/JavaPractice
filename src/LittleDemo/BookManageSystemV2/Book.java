package LittleDemo.BookManageSystemV2;

/**
 * ͼ��ʵ����
 * 
 * @author ����
 *
 */
public class Book {
	private String bookId; // ͼ����ڲ����
	private String bookName; // ͼ�������
	private String isdn; // �����
	private String type; // ���ݵ�����
	private String auther; // ����
	private String publisher; // ������
	private int count; // ��ǵĿ����
	private double price; // ����

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
