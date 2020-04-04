package Study.ExceptionDispose;

import java.util.Scanner;

/**
 * 输入不匹配异常实例
 * 用户输入的年龄只能是整形，使用异常处理机制捕获并处理
 * @author 马坤
 *
 */
public class InputMismatchExceptionDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入年龄（必须是整形数字）：");
		int age = -1;
		try {
				age  = input.nextInt();
		} catch (Exception e) {
			//e.printStackTrace();		//尽量使用堆栈打印
			System.err.println(e.getMessage());
		}
		System.out.println("输入的年龄是：" + age);
		
		
	}

}
