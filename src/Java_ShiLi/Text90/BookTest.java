/**  
* <p>Title: BookTest.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Mar 29, 2019  
* @version 1.0  
*/ 
package Java_ShiLi.Text90;

import java.util.Random;

/**  
* <p>Title: BookTest</p>  
* <p>Description: </p>  
* @author 马坤  
* @date Mar 29, 2019  
*/
public class BookTest {
	public static void main(String[] args) {
		String[] titles = {"四级词汇", "Java", "web"};
		for (int i = 0; i < 5; i++) {
			new Book(titles[new Random().nextInt(3)]);
		}
		System.out.println("总计销售了" + Book.getCounter() + "本图书！");
	}

}
