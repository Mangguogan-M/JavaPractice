package Study.Generic.One;

public class GeneralStackTest {
    public static void main(String[] args) {
        GeneralStack generalStack = new GeneralStack();
        System.out.println("��ջ�������ַ�����");
        System.out.println("��ƵѧJava");
        System.out.println("ϸ˵Java");
        System.out.println("Java�����ŵ���ͨ(��2��)");
        generalStack.push("��ƵѧJava");
        generalStack.push("ϸ˵Java");
        generalStack.push("Java�����ŵ���ͨ(��2��)");
        System.out.println("��ջ��ȡ���ַ�����");
        while (!generalStack.empty()) {
            System.out.println((String) generalStack.pop());
        }
    }
}
