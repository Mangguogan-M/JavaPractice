package Study.ExceptionDispose;
/**
 * �ֶ��׳��쳣
 * @author ����
 *
 */
public class ThrowDemo {

	public static void main(String[] args) {
		Hero hero = new Hero("����");
		try {
			hero.setExp(1000);
			hero.setHealth(40);
			hero.rideHose();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("���þ���ֵʱ�����쳣��" + e.getMessage());
		}
		System.out.println("��ǰӢ�۵ľ���ֵΪ��" + hero.getExp());
	}
}
class Hero{
	private String name;
	private long exp;
	private int health;
	
	public Hero(String name) {
		setName(name);
	}
	
	public void rideHose() throws LessThanZeroException {
		if(health >= 50)
			System.out.println(name + "���ڿ��ֵ�����");
		else
			throw new LessThanZeroException(health);
	}
	
	public int getHealth() {
		return health;
	}



	public void setHealth(int health) {
		this.health = health;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getExp() {
		return exp;
	}
	public void setExp(long exp) throws Exception {
		if(exp >= 0)
			this.exp = exp;
		else
			throw new Exception("����ֵ����Ϊ��ֵ��");
	}
}
