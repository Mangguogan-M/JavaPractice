package Study.Decorator;
/**
 * 装饰器父类，用来为基本的组建实现功能的扩展
 * @author 马坤
 *
 */
public class Decorator extends Component{
	private Component component;
	
	public Decorator(Component component) {
		this.component = component;
	}
	
	@Override
	public void read() {
		//注意观察：谁真正实现read方法
		//将请求转发给component对象，转发后，就可以执行一些扩展操作了
		component.read();
		
	}

}
