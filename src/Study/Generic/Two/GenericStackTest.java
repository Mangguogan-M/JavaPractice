package Study.Generic.Two;

public class GenericStackTest {
    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<String>();
        System.out.println("��ջ�������ַ�����");
        System.out.println("��ƵѧJava");
        System.out.println("ϸ˵Java");
        System.out.println("Java�����ŵ���ͨ(��2��)");
        stack.push("��ƵѧJava");  //��ջ�������ַ���
        stack.push("ϸ˵Java");   //��ջ�������ַ���
        stack.push("Java�����ŵ���ͨ(��2��)"); //��ջ�������ַ���
        System.out.println("��ջ��ȡ���ַ�����");
        while (!stack.empty()) {
            System.out.println((String) stack.pop());//ɾ��ջ��ȫ��Ԫ�ز��������
        }
    }
}

