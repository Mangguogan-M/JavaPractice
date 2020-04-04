package Study.ExceptionDispose;
/**
 * 自定义小于0异常
 * @author 马坤
 *
 */
public class LessThanZeroException extends Exception{
	
	private int value;
	
	public LessThanZeroException() {
		super("数字不饿能小于0");
	}
	
	public LessThanZeroException(int value) {
		super("输入的数字为：" + value + ",不能小于0！");
	}
}
