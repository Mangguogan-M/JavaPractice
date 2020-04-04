package Study.Decorator;
/**
 * 装饰器的实现类A
 * @author 马坤
 *
 */
public class ComponentImpA extends Decorator{
	public ComponentImpA(Component component) {
		super(component);
	}
	
	@Override
	public void read() {
		//注意：在原始的read方法前后，风别调用自定义的方法
		//既实现了对原方法的扩展
		this.extendsReadA();
		super.read();		//原始的read方法
		this.extendsReadB();
	}
	
	
	
	private void extendsReadA() {
		System.out.println("自定义的扩展方法：extendsReadA()");
	}
	
	private void extendsReadB() {
		System.out.println("自定义的扩展方法：extendsReadB()");
	}
	

}
