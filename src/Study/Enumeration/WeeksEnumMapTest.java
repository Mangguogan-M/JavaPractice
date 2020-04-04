package Study.Enumeration;

import static Study.Enumeration.Weeks.MONDAY;
import static Study.Enumeration.Weeks.SATURADAY;
import static Study.Enumeration.Weeks.SUNDAY;

import java.util.EnumMap;

public class WeeksEnumMapTest {
    public static void main(String[] args) {
        EnumMap<Weeks, String> weeks = new EnumMap<Weeks, String>(Weeks.class);
        weeks.put(MONDAY, "星期一");
        weeks.put(SUNDAY, "星期日");
        System.out.println("EnumMap中的键值对个数：" + weeks.size());
        System.out.println("EnumMap中的键值对：" + weeks);
        System.out.println("EnumMap中是否包含键SATURADAY："
                + weeks.containsKey(SATURADAY));
        System.out.println("EnumMap中是否包含值星期日：" + weeks.containsValue("星期日"));
        weeks.remove(MONDAY);
        System.out.println("EnumMap中的键值对：" + weeks);
        System.out.println("EnumMap中键MONDAY对应的值：" + weeks.get(MONDAY));
    }
}
