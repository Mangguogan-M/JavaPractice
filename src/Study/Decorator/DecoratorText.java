package Study.Decorator;

public class DecoratorText {

	public static void main(String[] args) {
		//创建要被转世的原始对象
		Component component = new TrueComponent();
		//为原始对象透明的增加功能
		ComponentImpA componentA = new ComponentImpA(component);
		componentA.read();
	}

}
