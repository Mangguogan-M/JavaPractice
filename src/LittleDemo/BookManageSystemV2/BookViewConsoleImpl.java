package LittleDemo.BookManageSystemV2;

import java.util.Scanner;

/**
 * ����ϵͳ����Ŀ���̨ʵ����
 * @author ����
 *
 */
public class BookViewConsoleImpl extends AbstractBookView{

	private Scanner input = null;
	private BookBiz bookBiz = null;
	public BookViewConsoleImpl() {
		input = new Scanner(System.in);
		bookBiz = new BookBiz();
		
		System.out.println("***************************************");
		System.out.println("\t��ӭʹ��ͼ�����ϵͳ");
		System.out.println("\t1����½\t2���Ƴ�ϵͳ");
		System.out.println("***************************************");
		System.out.println("��ѡ��");
		String choice = input.next();
		if ("1".equals(choice)) {
			System.out.println("Ϊʵ�֣��ѵ�¼��");
			//while(showMainView()){}
			//showMainView();
			doMainView();
		}
		System.out.println("ϵͳ���˳�����ӭ�´�ʹ�ã�");
		}
	
	@Override
	public String showMainView() {
		System.out.println("\nͼ�����ϵͳ  >> ���˵�");
		System.out.println("1������ͼ��\t2��ɾ��ͼ��\t3���鿴����ͼ��\t4������Ų�ѯ\t5�����\t6������\t7���˳�");
		System.out.println("��ѡ��");
		String choice = input.next();
		return choice;
	}

	@Override
	public void showOutStore() {
		System.out.println("\\nͼ�����ϵͳ  >> ����");
		System.out.println("�����ͼ���ţ�");
		String bookId = input.next();
		System.out.println("�����������");
		int bookCount = input.nextInt();
		if(bookBiz.outStore(bookId, bookCount)) {
			System.out.println("����ɹ���");
			showBooks(null);
		}else {
			System.out.println("����ʧ�ܣ����������ͼ���Ż����ͼ��������Ƿ��ޣ�");
		}		
	}

	@Override
	public void showInStore() {
		System.out.println("\\nͼ�����ϵͳ  >> ���");
		System.out.println("����ͼ���ţ�");
		String bookId = input.next();
		System.out.println("����������");
		int bookCount = input.nextInt();
		if(bookBiz.inStore(bookId, bookCount)) {
			System.out.println("���ɹ���");
			showBooks(null);
		}else {
			System.out.println("���ʧ�ܣ����������ͼ���ţ�");
		}		
	}

	@Override
	public void showFindById() {
		System.out.println("\\nͼ�����ϵͳ  >> ����Ų�ѯ");
		System.out.println("������Ҫ��ѯ��ͼ���ţ�");
		String bookId = input.next();
		Book book = bookBiz.findById(bookId);
		if (book == null) {
			System.out.println("û���ҵ��κ�ͼ����Ϣ��");
			return;
		}
		showBooks(book);		
	}

	@Override
	public void showDelBooView() {
		System.out.println("\\nͼ�����ϵͳ  >> ɾ��ͼ��");
		System.out.println("������Ҫɾ����ͼ���ţ�");
		String delId = input.next();
		Book delBook = new Book();
		delBook.setBookId(delId);
		if (bookBiz.delBook(delBook)) {//���ɾ���ɹ�
			System.out.println("ɾ���ɹ���");
			showBooks(null);
		}else {
			System.err.println("ɾ��ʧ�ܣ�");
		}		
	}

	@Override
	public Book showAddNewBookView() {
		System.out.println("\nͼ�����ϵͳ  >> ���˵�");
		System.out.println("�ڲ���ţ�");
		String bookId = input.next();
		Book newBook = bookBiz.findById(bookId);
		if(newBook == null) {
			newBook = new Book();
			newBook.setBookId(bookId);
			System.out.println("���ƣ�");
			newBook.setBookName(input.next());
			System.out.println("��棺");
			newBook.setCount(input.nextInt());
			
			bookBiz.addBook(newBook);
		}else {
			System.out.println("�ڲ�����Ѵ��ڣ�������¼�룡");
			newBook = showAddNewBookView();
		}
		return newBook;
	}

	@Override
	public void showBooks(Book... BookArray) {
		System.out.println("�ڲ���ţ�\t���ƣ�\t\t��棺");
		if (BookArray == null) {
			BookArray = Datas.BookStore;
		}
		int bookCount = bookBiz.getBookCount(BookArray);
		for (int i = 0; i < bookCount; i++) {
			System.out.printf("%s\t\t%s\t%d\n",BookArray[i].getBookId(),BookArray[i].getBookName(),BookArray[i].getCount());
		}		
	}
	
}
