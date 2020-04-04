
package Study.CreateClassByReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**  
* <p>Title: ClassViewer</p>  
* <p>Description: �鿴��ĳ�Ա</p>  
* @author ����  
* @date Apr 10, 2019  
*/
public class ClassViewer {
	@SuppressWarnings("unchecked")
	public static void main(String[] args)throws ClassNotFoundException{
		Class<?> clazz = Class.forName("java.util.ArrayList");
		System.out.println("��ı�׼���ƣ�" + clazz.getCanonicalName());
		Constructor[] constructors = clazz.getConstructors();
		System.out.println("��Ĺ��췽����");
		if (constructors.length != 0) {
			for (Constructor constructor : constructors) {
				System.out.println("\t" + constructor);
			}
		}else {
			System.out.println("��");
		}
		Field[] fields = clazz.getDeclaredFields();
		System.out.println("��ķǼ̳��������");
		if (fields.length != 0) {
			for (Field field : fields) {
				System.out.println("\t"+ field);
			}
		}else {
			System.out.println("\t��");
		}
		Method[] methods = clazz.getDeclaredMethods();
		System.out.println("���еķǼ̳з�����");
		if (methods.length != 0) {
			for (Method method : methods) {
				System.out.println(method);
			}
		}else {
			System.out.println("\t��");
		}
	}

}
