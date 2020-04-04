package Study.ExceptionDispose;
/**
 * 手动抛出异常
 * @author 马坤
 *
 */
public class ThrowDemo {

	public static void main(String[] args) {
		Hero hero = new Hero("吕布");
		try {
			hero.setExp(1000);
			hero.setHealth(40);
			hero.rideHose();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("设置经验值时出现异常！" + e.getMessage());
		}
		System.out.println("当前英雄的经验值为：" + hero.getExp());
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
			System.out.println(name + "正在快乐的骑马！");
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
			throw new Exception("经验值不能为负值！");
	}
}
