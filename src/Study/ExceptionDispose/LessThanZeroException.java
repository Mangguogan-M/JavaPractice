package Study.ExceptionDispose;
/**
 * �Զ���С��0�쳣
 * @author ����
 *
 */
public class LessThanZeroException extends Exception{
	
	private int value;
	
	public LessThanZeroException() {
		super("���ֲ�����С��0");
	}
	
	public LessThanZeroException(int value) {
		super("���������Ϊ��" + value + ",����С��0��");
	}
}
