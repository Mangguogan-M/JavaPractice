package LittleDemo.VirusBroadcast;
/**
 * 模拟参数
 *
 * @ClassName: Constants
 * @Description: 模拟参数
 * @author: Bruce Young
 * @date: 2020�?02�?02�? 21:40
 */
public class Constants {

    public static int ORIGINAL_COUNT = 50;//初始感染数量
    public static float BROAD_RATE = 0.8f;//传播�?
    public static float SHADOW_TIME = 140;//潜伏时间�?14天为140
    public static int HOSPITAL_RECEIVE_TIME = 10;//医院收治响应时间
    public static int BED_COUNT = 1000;//医院床位
    /**
     * 流动意向平均值，建议调整范围：[-0.99,0.99]
     * <p>
     * -0.99 人群流动�?慢�?�率，甚至完全控制疫情传�?
     * 0.99为人群流动最快�?�率, 可导致全城感�?
     */
    public static float u = 0.99f;
    public static int CITY_PERSON_SIZE = 5000;//城市总人口数�?
    public static float FATALITY_RATE = 0.50f;//fatality_rate病死率，根据2�?6日数据估算（病死�?/确诊数）�?0.02
    public static int DIE_TIME = 100;//死亡时间均�?�，30天，从发病（确诊）时�?始计�?
    public static double DIE_VARIANCE = 1;//死亡时间方差
    /**
     * 城市大小即窗口边界，限制不允许出�?
     */
    public static final int CITY_WIDTH = 700;
    public static final int CITY_HEIGHT = 800;

}
