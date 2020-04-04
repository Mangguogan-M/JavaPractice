/**  
* <p>Title: Child.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Mar 29, 2019  
* @version 1.0  
*/ 
package Java_ShiLi.Text89;

/**  
* <p>Title: Child</p>  
* <p>Description: </p>  
* @author 马坤  
* @date Mar 29, 2019  
*/
public class Child extends Ancestor{
	public static void main(String[] args) {
		Child child = new Child();
		System.out.println("获得药方：");
		System.out.println(child.getPrecription());
	}
}
