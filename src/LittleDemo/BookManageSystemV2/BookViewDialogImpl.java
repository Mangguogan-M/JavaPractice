package LittleDemo.BookManageSystemV2;

import javax.swing.JOptionPane;

public class BookViewDialogImpl extends AbstractBookView{
	private BookBiz bookBiz = null;
	public BookViewDialogImpl() {
		bookBiz = new BookBiz();
	}
	@Override
	public String showMainView() {

		String strMenu = "\nͼ�����ϵͳ  >> ���˵�";
		strMenu += "1������ͼ��\t2��ɾ��ͼ��\t3���鿴����ͼ��\t4������Ų�ѯ\t5�����\t6������\t7���˳�";
		strMenu += "��ѡ��";
		String result = JOptionPane.showInputDialog(strMenu);
		if (result == null) {
			result = "7";
		}
		return result;
		
	}
	@Override
	public void showOutStore() {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void showInStore() {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void showFindById() {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void showDelBooView() {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public Book showAddNewBookView() {
		Book newBook = new Book();
		String bookId = null;
		String bookName = null;
		int count = -1;
		bookId = JOptionPane.showInputDialog("������ͼ���ţ�");
		bookName = JOptionPane.showInputDialog("ͼ�����ƣ�");
		count = Integer.parseInt(JOptionPane.showInputDialog("�������"));
		
		newBook.setBookId(bookId);
		newBook.setBookName(bookName);
		newBook.setCount(count);
		if(bookBiz.addBook(newBook)) {
			JOptionPane.showMessageDialog(null, "��ӳɹ���");
		}else {
			JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
		}
		
		return newBook;
	}
	@Override
	public void showBooks(Book... BookArray) {
		// TODO �Զ����ɵķ������
		
	}
}
