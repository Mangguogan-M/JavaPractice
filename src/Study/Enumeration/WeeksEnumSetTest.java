package Study.Enumeration;

import static Study.Enumeration.Weeks.MONDAY;
import static Study.Enumeration.Weeks.THURSDAY;

import java.util.EnumSet;


public class WeeksEnumSetTest {
    public static void main(String[] args) {
        EnumSet<Weeks> week = EnumSet.noneOf(Weeks.class);
        week.add(MONDAY);
        System.out.println("EnumSet�е�Ԫ�أ�" + week);
        week.remove(MONDAY);
        System.out.println("EnumSet�е�Ԫ�أ�" + week);
        week.addAll(EnumSet.complementOf(week));
        System.out.println("EnumSet�е�Ԫ�أ�" + week);
        week.removeAll(EnumSet.range(MONDAY, THURSDAY));
        System.out.println("EnumSet�е�Ԫ�أ�" + week);
    }
}
