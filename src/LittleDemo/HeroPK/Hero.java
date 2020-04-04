package LittleDemo.HeroPK;
/**
 * 英雄类   父类
 * @author 马坤
 *
 */
public abstract class Hero {
	private long id;
	private String name;
	private int level;
	private int maxHp;
	private int hp;
	private int attack;
	private int x;
	private int y;
	
	public Hero() {
		setMaxHp(100);
		setHp(100);
	}
	
	public Hero(long id, String name) {
		this();
		setId(id);
		setName(name);
	}
	
	public void PK(Hero hero) {
		//1、计算距离能否攻击对方
		if (canFightByDistance(hero) && hp > 0 && hero.getHp() > 0) {
			fight(hero);
		}else {
			System.out.println("由于攻击距离太远，无法攻击！");
		}
		//2、如果可以攻击，就调用攻击方法
		System.out.println("两位英雄当前的状态：");
		System.out.println("昵称\tHP\tx坐标\tY坐标");
		System.out.println(name + "\t" + hp + "\t" + x + "\t" + y);
		System.out.printf("%s\t%d\t%d\t%d",
				hero.getName(), hero.getHp(), hero.getX(), hero.getY());
	}
	
	/**
	 * 判断当前英雄是否能够攻击传入的英雄对象
	 * @param hero 攻击的对象
	 * @return 能否攻击
	 */
	public abstract boolean canFightByDistance(Hero hero);
	
	/**
	 * 攻击传入的英雄对象，默认根据随机生成的攻击力减扣hp值
	 * @param hero 
	 */
	public abstract void fight(Hero hero);
	
	protected double getDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if (level < 0 || level > 100) {
			this.level = 1;
		}else {
			this.level = level;
		}
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
}
