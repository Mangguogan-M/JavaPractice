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
* <p>Description: ����ģʽ</p>  
* @author ����  
* @date Mar 29, 2019  
*/
public class Emperor {//private��ʾ˽�У�˽�е���˼���ǳ���class�Լ�֮�⣬�κ��˶�������ֱ��ʹ��
	private static Emperor emperor = null;
	private Emperor() {
	}
	public static Emperor getInstance() {//һ��ֻ��ʵ����һ��
		if (emperor == null) {
			emperor = new Emperor();
		}
		return emperor;
	}
	public void getName() {
		System.out.println("makun");
	}
}
