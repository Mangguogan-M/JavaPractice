package Java_ShiLi.Text109;
/**
 * 
* <p>Title: Employee</p>  
* <p>Description:  假克隆，不能使用=或者==号来进行克隆，那只是克隆了应用对象的名称，当改变其中一个的值时，宁一个也会变</p>  
* @author 马坤  
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
        return "姓名：" + name + ", 年龄：" + age;
    }
}
