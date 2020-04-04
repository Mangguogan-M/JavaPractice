/**  
* <p>Title: Book.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Mar 29, 2019  
* @version 1.0  
*/ 
package Java_ShiLi.Text90;

/**  
* <p>Title: Book</p>  
* <p>Description: </p>  
* @author 马坤  
* @date Mar 29, 2019  
*/
public class Book {
	private static int counter = 0;//static的使用方法
	public Book(String title) {
		System.out.println("售出图书：" + title);
		counter++;
	}
	public static int getCounter() {
		return counter;
	}

}
