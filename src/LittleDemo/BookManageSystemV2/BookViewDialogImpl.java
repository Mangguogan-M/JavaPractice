package LittleDemo.BookManageSystemV2;

import javax.swing.JOptionPane;

public class BookViewDialogImpl extends AbstractBookView{
	private BookBiz bookBiz = null;
	public BookViewDialogImpl() {
		bookBiz = new BookBiz();
	}
	@Override
	public String showMainView() {

		String strMenu = "\n图书管理系统  >> 主菜单";
		strMenu += "1、新增图书\t2、删除图书\t3、查看所有图书\t4、按编号查询\t5、入库\t6、出库\t7、退出";
		strMenu += "请选择：";
		String result = JOptionPane.showInputDialog(strMenu);
		if (result == null) {
			result = "7";
		}
		return result;
		
	}
	@Override
	public void showOutStore() {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void showInStore() {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void showFindById() {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void showDelBooView() {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public Book showAddNewBookView() {
		Book newBook = new Book();
		String bookId = null;
		String bookName = null;
		int count = -1;
		bookId = JOptionPane.showInputDialog("请输入图书编号：");
		bookName = JOptionPane.showInputDialog("图书名称：");
		count = Integer.parseInt(JOptionPane.showInputDialog("库存量："));
		
		newBook.setBookId(bookId);
		newBook.setBookName(bookName);
		newBook.setCount(count);
		if(bookBiz.addBook(newBook)) {
			JOptionPane.showMessageDialog(null, "添加成功！");
		}else {
			JOptionPane.showMessageDialog(null, "添加失败！");
		}
		
		return newBook;
	}
	@Override
	public void showBooks(Book... BookArray) {
		// TODO 自动生成的方法存根
		
	}
}
