package LittleDemo.BookManageSystemV1;

import java.util.Scanner;

public class BookView {
	private Scanner input = null;
	private BookBiz bookBiz = null;

	public BookView() {
		input = new Scanner(System.in);
		bookBiz = new BookBiz();

		System.out.println("***************************************");
		System.out.println("\t欢迎使用图书馆里系统");
		System.out.println("\t1、登陆\t2、推出系统");
		System.out.println("***************************************");
		System.out.println("请选择：");
		String choice = input.next();
		if ("1".equals(choice)) {
			System.out.println("为实现，已登录！");
			// while(showMainView()){}
			showMainView();
		}
		System.out.println("系统已退出，欢迎下次使用！");

	}

	public void showMainView() {
		System.out.println("\n图书管理系统  >> 主菜单");
		System.out.println("1、新增图书\t2、删除图书\t3、查看所有图书\t4、按编号查询\t5、入库\t6、出库\t7、退出");
		System.out.println("请选择：");
		String choice = input.next();
		switch (choice) {
		case "1":// 添加图书
			showAddNewBookView();
			showBooks(Datas.BookStore);
			break;
		case "2":// 删除图书
			showDelBooView();
			break;
		case "3":// 查看所有图书
			showBooks(null);
			break;
		case "4":// 按编号查询
			showFindById();
			break;
		case "5":// 入库
			showInStore();
			break;
		case "6":// 出库
			showOutStore();
			break;
		case "7":
			// System.exit(0);
			// return false;
			return;
		default:
			break;
		}
		// return true;
		showMainView();
	}

	/**
	 * 出库
	 */
	public void showOutStore() {
		System.out.println("\\n图书管理系统  >> 出库");
		System.out.println("出库的图书编号：");
		String bookId = input.next();
		System.out.println("出库的数量：");
		int bookCount = input.nextInt();
		if (bookBiz.outStore(bookId, bookCount)) {
			System.out.println("出库成功！");
			showBooks(null);
		} else {
			System.out.println("出库失败，请检查输入的图书编号或出库图书的数量是否超限！");
		}
	}

	/**
	 * 入库
	 */
	public void showInStore() {
		System.out.println("\\n图书管理系统  >> 入库");
		System.out.println("入库的图书编号：");
		String bookId = input.next();
		System.out.println("入库的数量：");
		int bookCount = input.nextInt();
		if (bookBiz.inStore(bookId, bookCount)) {
			System.out.println("入库成功！");
			showBooks(null);
		} else {
			System.out.println("入库失败，请检查输入的图书编号！");
		}
	}

	/**
	 * 按编号查询
	 */
	public void showFindById() {
		System.out.println("\\n图书管理系统  >> 按编号查询");
		System.out.println("请输入要查询的图书编号：");
		String bookId = input.next();
		Book book = bookBiz.findById(bookId);
		if (book == null) {
			System.out.println("没有找到任何图书信息！");
			return;
		}
		showBooks(book);
	}

	/**
	 * 删除图书
	 * 
	 * @return
	 */
	public void showDelBooView() {
		System.out.println("\\n图书管理系统  >> 删除图书");
		System.out.println("请输入要删除的图书编号：");
		String delId = input.next();
		Book delBook = new Book();
		delBook.setBookId(delId);
		if (bookBiz.delBook(delBook)) {// 如果删除成功
			System.out.println("删除成功！");
			showBooks(null);
		} else {
			System.err.println("删除失败！");
		}

	}

	public Book showAddNewBookView() {
		System.out.println("\n图书管理系统  >> 主菜单");
		System.out.println("内部编号：");
		String bookId = input.next();
		Book newBook = bookBiz.findById(bookId);
		if (newBook == null) {
			newBook = new Book();
			newBook.setBookId(bookId);
			System.out.println("名称：");
			newBook.setBookName(input.next());
			System.out.println("库存：");
			newBook.setCount(input.nextInt());

			bookBiz.addBook(newBook);
		} else {
			System.out.println("内部编号已存在，请重新录入！");
			newBook = showAddNewBookView();
		}
		return newBook;
	}

	/**
	 * 显示所有的图书信息
	 * 
	 * @param BookArray
	 */
	public void showBooks(Book... BookArray) {
		System.out.println("内部编号：\t名称：\t\t库存：");
		if (BookArray == null) {
			BookArray = Datas.BookStore;
		}
		int bookCount = bookBiz.getBookCount(BookArray);
		for (int i = 0; i < bookCount; i++) {
			System.out.printf("%s\t\t%s\t%d\n", BookArray[i].getBookId(), BookArray[i].getBookName(),
					BookArray[i].getCount());
		}
	}

}
