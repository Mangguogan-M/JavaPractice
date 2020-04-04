package Study.Decorator;
/**
 * 真正干活的组建类，实现read方法
 * @author 马坤
 *
 */
public class TrueComponent extends Component{

	@Override
	public void read() {
		System.out.println("TrueComponent实现的read方法");
		
	}
	
}
