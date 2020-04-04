package LittleDemo.VirusBroadcast;
import java.util.Random;

/**
 * 数学算法工具�?
 *
 * @ClassName: MathUtil
 * @Description: 数学算法工具�?
 * @author: Bruce Young
 * @date: 2020�?02�?06�? 11:27
 */
public class MathUtil {
    /**
     * 仅仅使用�?个随机数生成�?
     */
    private static final Random randomGen = new Random();

    /**
     * 标准正�?�分布化
     * <p>
     * 流动意愿标准化后判断是在0的左边还是右边从而决定是否流动�??
     * <p>
     * 设X随机变量为服从正态分布，sigma是影响分布形态的系数 u值决定正态分布均�?
     * <p>
     * <p>
     * 推导�?
     * StdX = (X-u)/sigma
     * X = sigma * StdX + u
     *
     * @param sigma 正�?�标准差sigma�?
     * @param u     正�?�均值参数mu
     * @return
     */
    public static double stdGaussian(double sigma, double u) {
        double X = randomGen.nextGaussian();
        return sigma * X + u;
    }

}
