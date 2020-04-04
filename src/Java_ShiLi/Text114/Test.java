package Java_ShiLi.Text114;
/**
 * transient的使用方法，transient修饰引用类型时返回null。修饰基本类型时返回0
* <p>Title: Test</p>  
* <p>Description: </p>  
* @author 马坤  
* @date Apr 2, 2019
 */
public class Test {
    
    public static void main(String[] args) {
        Login login1 = new Login("mingrisoft", "mr");
        System.out.println("输出原始对象的信息：");
        System.out.println(login1);
        System.out.println("输出克隆对象的信息：");
        Login login2 = login1.clone();
        System.out.println(login2);
    }
}
