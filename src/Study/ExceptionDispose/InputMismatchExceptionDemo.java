package Study.ExceptionDispose;

import java.util.Scanner;

/**
 * ���벻ƥ���쳣ʵ��
 * �û����������ֻ�������Σ�ʹ���쳣������Ʋ��񲢴���
 * @author ����
 *
 */
public class InputMismatchExceptionDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("���������䣨�������������֣���");
		int age = -1;
		try {
				age  = input.nextInt();
		} catch (Exception e) {
			//e.printStackTrace();		//����ʹ�ö�ջ��ӡ
			System.err.println(e.getMessage());
		}
		System.out.println("����������ǣ�" + age);
		
		
	}

}
