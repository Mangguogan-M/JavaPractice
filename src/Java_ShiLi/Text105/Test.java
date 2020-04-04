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
* @author 马坤  
* @date Apr 2, 2019  
*/
public class Test {
	public static void main(String[] args) {
		Cat cat1 = new Cat("Java", 12, 21, Color.BLACK);
		Cat cat2 = new Cat("C++", 12, 21, Color.WHITE);
		Cat cat3 = new Cat("Java", 12, 21, Color.BLACK);
		System.out.println("cat1的哈希码：" + cat1.hashCode());
		System.out.println("cat2的哈希码：" + cat2.hashCode());
		System.out.println("cat3的哈希码:" + cat3.hashCode());
		System.out.println("cat1和cat2是否相同：" + cat1.equals(cat2));
		System.out.println("cat1和cat3是否相同：" + cat1.equals(cat3));
	}
}
