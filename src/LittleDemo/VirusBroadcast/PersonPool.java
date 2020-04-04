package LittleDemo.VirusBroadcast;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 区域人群对象�?
 *
 * @ClassName: PersonPool
 * @Description: 区域人群对象池，该地区假设为�?个近似封闭的环境，拥有几乎不变的民众数量
 * @author: Bruce Young
 * @date: 2020�?02�?02�? 17:21
 */
public class PersonPool {
    private static PersonPool personPool = new PersonPool();

    public static PersonPool getInstance() {
        return personPool;
    }

    List<Person> personList = new ArrayList<Person>();

    public List<Person> getPersonList() {
        return personList;
    }


    /**
     * @param state 市民类型 Person.State的�?�，若为-1则返回当前�?�数�?
     * @return 获取指定人群数量
     */
    public int getPeopleSize(int state) {
        if (state == -1) {
            return personList.size();
        }
        int i = 0;
        for (Person person : personList) {
            if (person.getState() == state) {
                i++;
            }
        }
        return i;
    }
    

    private PersonPool() {
        City city = new City(400, 400);//设置城市中心为坐�?(400,400)
        //添加城市居民
        for (int i = 0; i < Constants.CITY_PERSON_SIZE; i++) {
            Random random = new Random();
            //产生N(a,b)的数：Math.sqrt(b)*random.nextGaussian()+a
            int x = (int) (100 * random.nextGaussian() + city.getCenterX());
            int y = (int) (100 * random.nextGaussian() + city.getCenterY());
            if (x > 700) {
                x = 700;
            }
            personList.add(new Person(city, x, y));
        }
    }
}
