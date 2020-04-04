package Study.ListSetMapVectorEtc;
/**
 * 理解泛型的基本含义
 * @author 马坤
 *
 */
public class ElementDemo {
	public static void main(String[] args) {
		Object[] objs = new Object[999];
		objs[0] = 1024;
		objs[1] = "abc";
		objs[2] = 19.9;
		objs[3] = new Student();
		
		Integer value1 = (Integer)objs[0];
		String value2 = (String)objs[1];
		
		System.out.println(value1);
		System.out.println(value2);
		
	}
}
class Student {
	
}
