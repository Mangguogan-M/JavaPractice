package Java_ShiLi.Text114;
/**
 * transient��ʹ�÷�����transient������������ʱ����null�����λ�������ʱ����0
* <p>Title: Test</p>  
* <p>Description: </p>  
* @author ����  
* @date Apr 2, 2019
 */
public class Test {
    
    public static void main(String[] args) {
        Login login1 = new Login("mingrisoft", "mr");
        System.out.println("���ԭʼ�������Ϣ��");
        System.out.println(login1);
        System.out.println("�����¡�������Ϣ��");
        Login login2 = login1.clone();
        System.out.println(login2);
    }
}
