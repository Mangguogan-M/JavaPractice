package Study.Generic.One;

public class GeneralStackTest {
    public static void main(String[] args) {
        GeneralStack generalStack = new GeneralStack();
        System.out.println("向栈中增加字符串：");
        System.out.println("视频学Java");
        System.out.println("细说Java");
        System.out.println("Java从入门到精通(第2版)");
        generalStack.push("视频学Java");
        generalStack.push("细说Java");
        generalStack.push("Java从入门到精通(第2版)");
        System.out.println("从栈中取出字符串：");
        while (!generalStack.empty()) {
            System.out.println((String) generalStack.pop());
        }
    }
}
