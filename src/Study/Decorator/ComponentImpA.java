package Study.Decorator;
/**
 * װ������ʵ����A
 * @author ����
 *
 */
public class ComponentImpA extends Decorator{
	public ComponentImpA(Component component) {
		super(component);
	}
	
	@Override
	public void read() {
		//ע�⣺��ԭʼ��read����ǰ�󣬷������Զ���ķ���
		//��ʵ���˶�ԭ��������չ
		this.extendsReadA();
		super.read();		//ԭʼ��read����
		this.extendsReadB();
	}
	
	
	
	private void extendsReadA() {
		System.out.println("�Զ������չ������extendsReadA()");
	}
	
	private void extendsReadB() {
		System.out.println("�Զ������չ������extendsReadB()");
	}
	

}
