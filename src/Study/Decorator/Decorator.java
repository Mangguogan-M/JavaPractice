package Study.Decorator;
/**
 * װ�������࣬����Ϊ�������齨ʵ�ֹ��ܵ���չ
 * @author ����
 *
 */
public class Decorator extends Component{
	private Component component;
	
	public Decorator(Component component) {
		this.component = component;
	}
	
	@Override
	public void read() {
		//ע��۲죺˭����ʵ��read����
		//������ת����component����ת���󣬾Ϳ���ִ��һЩ��չ������
		component.read();
		
	}

}
