package LittleDemo.BookManageSystemV2;

public abstract class AbstractBookView {

	public AbstractBookView() {
		// doMainView();
	}

	/**
	 * 本方法用来规定固定的程序逻辑
	 */
	public void doMainView() {
		String result = showMainView();
		switch (result) {
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
		doMainView();
	}

	/**
	 * 返回永辉悬着的菜单项（1——7）之间
	 * 
	 * @return
	 */
	public abstract String showMainView();

	/**
	 * 出库
	 */
	public abstract void showOutStore();

	/**
	 * 入库
	 */
	public abstract void showInStore();

	/**
	 * 按编号查询
	 */
	public abstract void showFindById();

	/**
	 * 删除图书
	 * 
	 * @return
	 */
	public abstract void showDelBooView();

	public abstract Book showAddNewBookView();

	/**
	 * 显示所有的图书信息
	 * 
	 * @param BookArray
	 */
	public abstract void showBooks(Book... BookArray);
}
