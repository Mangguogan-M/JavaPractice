package LittleDemo.VirusBroadcast;
import java.util.List;
import java.util.Random;

/**
 * 能够随机运动的民�?
 *
 * @ClassName: Person
 * @Description: 能够随机运动的民�?
 * @author: Bruce Young
 * @date: 2020�?02�?02�? 17:05
 */

public class Person extends Point {
    private City city;

    private MoveTarget moveTarget;
    /**
     * 人群流动意愿影响系数：正态分布方差sigma
     */
    int sig = 1;

    /**
     * 正�?�分布N(mu,sigma)随机位移目标位置
     */

    double targetXU;//x方向的均值mu
    double targetYU;//y方向的均值mu
    double targetSig = 50;//方差sigma

    /**
     * 市民的状�?
     * <p>
     * 市民状�?�应该需要细分，虽然有的状�?�暂未纳入模拟，但是细分状�?�应该保�?
     */
    public interface State {
        int NORMAL = 0;//正常人，未感染的健康�?
        int SUSPECTED = NORMAL + 1;//有暴露感染风�?
        int SHADOW = SUSPECTED + 1;//潜伏�?
        int CONFIRMED = SHADOW + 1;//发病且已确诊为感染病�?
        int FREEZE = CONFIRMED + 1;//隔离治疗，禁止位�?

        //已治愈出院的人转为NORMAL即可，否则会与作者�?�过数�?�大小判断状态的代码冲突
        int DEATH = FREEZE + 1;//病死�?
        //int CURED = DEATH + 1;//治愈数量用于计算治愈出院后归还床位数量，该状态是否存续待�?
    }

    public Person(City city, int x, int y) {
        super(x, y);
        this.city = city;
        //对市民的初始位置进行N(x,100)的正态分布随�?
        targetXU = MathUtil.stdGaussian(100, x);
        targetYU = MathUtil.stdGaussian(100, y);

    }

    /**
     * 流动意愿标准�?
     * <p>
     * 根据标准正�?�分布生成随机人口流动意�?
     * <p>
     * 流动意愿标准化后判断是在0的左边还是右边从而决定是否流动�??
     * <p>
     * 设X随机变量为服从正态分布，sigma是影响分布形态的系数，从而影响整体人群流动意愿分�?
     * u值决定正态分布的中轴是让更多人群偏向希望流动或�?�希望懒惰�??
     * <p>
     * value的推导：
     * StdX = (X-u)/sigma
     * X = sigma * StdX + u
     *
     * @return
     */
    public boolean wantMove() {
        return MathUtil.stdGaussian(sig, Constants.u) > 0;
    }

    private int state = State.NORMAL;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    int infectedTime = 0;//感染时刻
    int confirmedTime = 0;//确诊时刻
    int dieMoment = 0;//死亡时刻，为0代表未确定，-1代表不会病死


    public boolean isInfected() {
        return state >= State.SHADOW;
    }

    public void beInfected() {
        state = State.SHADOW;
        infectedTime = MyPanel.worldTime;
    }

    /**
     * 计算两点之间的直线距�?
     *
     * @param person
     * @return
     */
    public double distance(Person person) {
        return Math.sqrt(Math.pow(getX() - person.getX(), 2) + Math.pow(getY() - person.getY(), 2));
    }

    /**
     * 住院
     */
    private void freezy() {
        state = State.FREEZE;
    }

    /**
     * 不同状�?�下的单个人实例运动行为
     */
    private void action() {

        if (state == State.FREEZE || state == State.DEATH) {
            return;//如果处于隔离或�?�死亡状态，则无法行�?
        }
        if (!wantMove()) {
            return;
        }
        //存在流动意愿的，将进行流动，流动位移仍然遵循标准正�?�分�?
        if (moveTarget == null || moveTarget.isArrived()) {
            //在想要移动并且没有目标时，将自身移动目标设置为随机生成的符合正�?�分布的目标�?
            //产生N(a,b)的数：Math.sqrt(b)*random.nextGaussian()+a
            double targetX = MathUtil.stdGaussian(targetSig, targetXU);
            double targetY = MathUtil.stdGaussian(targetSig, targetYU);
            moveTarget = new MoveTarget((int) targetX, (int) targetY);

        }

        //计算运动位移
        int dX = moveTarget.getX() - getX();
        int dY = moveTarget.getY() - getY();

        double length = Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));//与目标点的距�?

        if (length < 1) {
            //判断是否到达目标�?
            moveTarget.setArrived(true);
            return;
        }

        int udX = (int) (dX / length);//x轴dX为位移量，符号为沿x轴前进方�?, 即udX为X方向表示�?
        if (udX == 0 && dX != 0) {
            if (dX > 0) {
                udX = 1;
            } else {
                udX = -1;
            }
        }


        int udY = (int) (dY / length);//y轴dY为位移量，符号为沿x轴前进方向，即udY为Y方向表示�?
        //FIXED: 修正�?处错�?
        if (udY == 0 && dY != 0) {
            if (dY > 0) {
                udY = 1;
            } else {
                udY = -1;
            }
        }

        //横向运动边界
        if (getX() > Constants.CITY_WIDTH || getX() < 0) {
            moveTarget = null;
            if (udX > 0) {
                udX = -udX;
            }
        }
        //纵向运动边界
        if (getY() > Constants.CITY_HEIGHT || getY() < 0) {
            moveTarget = null;
            if (udY > 0) {
                udY = -udY;
            }
        }
        moveTo(udX, udY);

    }

    public Bed useBed;

    private float SAFE_DIST = 2f;//安全距离

    /**
     * 对各种状态的人进行不同的处理，更新发布市民健康状�?
     */
    public void update() {
        //@TODO找时间改为状态机

        if (state == State.FREEZE || state == State.DEATH) {
            return;//如果已经隔离或�?�死亡了，就不需要处理了
        }

        //处理已经确诊的感染�?�（即患者）
        if (state == State.CONFIRMED && dieMoment == 0) {

            int destiny = new Random().nextInt(10000) + 1;//幸运数字，[1,10000]随机�?
            if (1 <= destiny && destiny <= (int) (Constants.FATALITY_RATE * 10000)) {

                //如果幸运数字落在死亡区间
                int dieTime = (int) MathUtil.stdGaussian(Constants.DIE_VARIANCE, Constants.DIE_TIME);
                dieMoment = confirmedTime + dieTime;//发病后确定死亡时�?
            } else {
                dieMoment = -1;//逃过了死神的魔爪

            }
        }
        //TODO 暂时缺失治愈出院市民的处理�?�需要确定一个变量用于治愈时长�?�由于案例太少，暂不加入�?


        if (state == State.CONFIRMED
                && MyPanel.worldTime - confirmedTime >= Constants.HOSPITAL_RECEIVE_TIME) {
            //如果患�?�已经确诊，且（世界时刻-确诊时刻）大于医院响应时间，即医院准备好病床了，可以抬走�?
            Bed bed = Hospital.getInstance().pickBed();//查找空床�?
            if (bed == null) {

                //没有床位了，报告�?求床位数

            } else {
                //安置病人
                useBed = bed;
                state = State.FREEZE;
                setX(bed.getX());
                setY(bed.getY());
                bed.setEmpty(false);
            }
        }

        //处理病死�?
        if ((state == State.CONFIRMED || state == State.FREEZE) && MyPanel.worldTime >= dieMoment && dieMoment > 0) {
            state = State.DEATH;//患�?�死�?
            Hospital.getInstance().returnBed(useBed);//归还床位
        }

        //增加�?个正态分布用于潜伏期内随机发病时�?
        double stdRnShadowtime = MathUtil.stdGaussian(25, Constants.SHADOW_TIME / 2);
        //处理发病的潜伏期感染�?
        if (MyPanel.worldTime - infectedTime > stdRnShadowtime && state == State.SHADOW) {
            state = State.CONFIRMED;//潜伏者发�?
            confirmedTime = MyPanel.worldTime;//刷新时间
        }
        //处理未隔离�?�的移动问题
        action();
        //处理健康人被感染的问�?
        List<Person> people = PersonPool.getInstance().personList;
        if (state >= State.SHADOW) {
            return;
        }
        //通过�?个随机幸运�?�和安全距离决定感染其他�?
        for (Person person : people) {
            if (person.getState() == State.NORMAL) {
                continue;
            }
            float random = new Random().nextFloat();
            if (random < Constants.BROAD_RATE && distance(person) < SAFE_DIST) {
                this.beInfected();
                break;
            }
        }
    }
}
