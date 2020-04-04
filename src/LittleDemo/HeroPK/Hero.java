package LittleDemo.HeroPK;
/**
 * Ӣ����   ����
 * @author ����
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
		//1����������ܷ񹥻��Է�
		if (canFightByDistance(hero) && hp > 0 && hero.getHp() > 0) {
			fight(hero);
		}else {
			System.out.println("���ڹ�������̫Զ���޷�������");
		}
		//2��������Թ������͵��ù�������
		System.out.println("��λӢ�۵�ǰ��״̬��");
		System.out.println("�ǳ�\tHP\tx����\tY����");
		System.out.println(name + "\t" + hp + "\t" + x + "\t" + y);
		System.out.printf("%s\t%d\t%d\t%d",
				hero.getName(), hero.getHp(), hero.getX(), hero.getY());
	}
	
	/**
	 * �жϵ�ǰӢ���Ƿ��ܹ����������Ӣ�۶���
	 * @param hero �����Ķ���
	 * @return �ܷ񹥻�
	 */
	public abstract boolean canFightByDistance(Hero hero);
	
	/**
	 * ���������Ӣ�۶���Ĭ�ϸ���������ɵĹ���������hpֵ
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
