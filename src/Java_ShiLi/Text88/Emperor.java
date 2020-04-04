/**  
* <p>Title: Emperor.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Mar 29, 2019  
* @version 1.0  
*/ 
package Java_ShiLi.Text88;

/**  
* <p>Title: Emperor</p>  
* <p>Description: 单例模式</p>  
* @author 马坤  
* @date Mar 29, 2019  
*/
public class Emperor {//private表示私有，私有的意思就是除了class自己之外，任何人都不可以直接使用
	private static Emperor emperor = null;
	private Emperor() {
	}
	public static Emperor getInstance() {//一次只能实例化一个
		if (emperor == null) {
			emperor = new Emperor();
		}
		return emperor;
	}
	public void getName() {
		System.out.println("makun");
	}
}
