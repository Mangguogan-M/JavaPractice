package Java_ShiLi.Text109;
/**
 * 
* <p>Title: Employee</p>  
* <p>Description:  �ٿ�¡������ʹ��=����==�������п�¡����ֻ�ǿ�¡��Ӧ�ö�������ƣ����ı�����һ����ֵʱ����һ��Ҳ���</p>  
* @author ����  
* @date Apr 2, 2019
 */
public class Employee {
    private String name;
    private int age;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "������" + name + ", ���䣺" + age;
    }
}
