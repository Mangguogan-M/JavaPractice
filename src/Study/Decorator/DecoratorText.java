package Study.Decorator;

public class DecoratorText {

	public static void main(String[] args) {
		//����Ҫ��ת����ԭʼ����
		Component component = new TrueComponent();
		//Ϊԭʼ����͸�������ӹ���
		ComponentImpA componentA = new ComponentImpA(component);
		componentA.read();
	}

}
