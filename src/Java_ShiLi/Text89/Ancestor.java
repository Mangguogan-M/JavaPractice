/**  
* <p>Title: Ancestor.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Mar 29, 2019  
* @version 1.0  
*/ 
package Java_ShiLi.Text89;

/**  
* <p>Title: Ancestor</p>  
* <p>Description: </p>  
* @author 马坤  
* @date Mar 29, 2019  
*/
public class Ancestor {
	private String prescription = "挠挠";
	protected String getPrecription() {//protected对于子女、朋友来说，就是public的，可以自由使用，没有任何限制，而对于其他的外部class，protected就变成private
		return prescription;
	}

}
