/**  
* <p>Title: Test.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Apr 2, 2019  
* @version 1.0  
*/ 
package Java_ShiLi.Text105;

import java.awt.Color;

/**  
* <p>Title: Test</p>  
* <p>Description: </p>  
* @author ����  
* @date Apr 2, 2019  
*/
public class Test {
	public static void main(String[] args) {
		Cat cat1 = new Cat("Java", 12, 21, Color.BLACK);
		Cat cat2 = new Cat("C++", 12, 21, Color.WHITE);
		Cat cat3 = new Cat("Java", 12, 21, Color.BLACK);
		System.out.println("cat1�Ĺ�ϣ�룺" + cat1.hashCode());
		System.out.println("cat2�Ĺ�ϣ�룺" + cat2.hashCode());
		System.out.println("cat3�Ĺ�ϣ��:" + cat3.hashCode());
		System.out.println("cat1��cat2�Ƿ���ͬ��" + cat1.equals(cat2));
		System.out.println("cat1��cat3�Ƿ���ͬ��" + cat1.equals(cat3));
	}
}
