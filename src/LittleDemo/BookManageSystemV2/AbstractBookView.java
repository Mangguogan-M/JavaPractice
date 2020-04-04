package LittleDemo.BookManageSystemV2;

public abstract class AbstractBookView {

	public AbstractBookView() {
		// doMainView();
	}

	/**
	 * �����������涨�̶��ĳ����߼�
	 */
	public void doMainView() {
		String result = showMainView();
		switch (result) {
		case "1":// ���ͼ��
			showAddNewBookView();
			showBooks(Datas.BookStore);
			break;
		case "2":// ɾ��ͼ��
			showDelBooView();
			break;
		case "3":// �鿴����ͼ��
			showBooks(null);
			break;
		case "4":// ����Ų�ѯ
			showFindById();
			break;
		case "5":// ���
			showInStore();
			break;
		case "6":// ����
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
	 * �����������ŵĲ˵��1����7��֮��
	 * 
	 * @return
	 */
	public abstract String showMainView();

	/**
	 * ����
	 */
	public abstract void showOutStore();

	/**
	 * ���
	 */
	public abstract void showInStore();

	/**
	 * ����Ų�ѯ
	 */
	public abstract void showFindById();

	/**
	 * ɾ��ͼ��
	 * 
	 * @return
	 */
	public abstract void showDelBooView();

	public abstract Book showAddNewBookView();

	/**
	 * ��ʾ���е�ͼ����Ϣ
	 * 
	 * @param BookArray
	 */
	public abstract void showBooks(Book... BookArray);
}
