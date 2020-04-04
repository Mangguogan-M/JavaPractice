package Study.ListSetMapVectorEtc;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		//HashSetDemo();
		//LinkedHashSetDemo();
		TreeSet();
	}

	public static void TreeSet() {
		TreeSet<String> citySet = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.compareTo(o2) > 0) return -1;
				if (o1.compareTo(o2) < 0) return 1;
				return 0;
			}
		});
		citySet.add("London");
		citySet.add("Parise");
		citySet.add("New York");
		citySet.add("Bei Jing");
		citySet.add("Shang Hai");
		citySet.forEach(str -> System.out.println(str + ",   "));
		System.out.println();
		System.out.println(citySet.lower("N"));
		System.out.println();
		System.out.println(citySet.higher("N"));
		System.out.println("New York֮ǰ��Ԫ�ؼ��ϣ�" + citySet.headSet("New York"));
		System.out.println("New York֮���Ԫ�ؼ��ϣ�" + citySet.tailSet("New York"));
		System.out.println("��Ԫ�أ�" + citySet.first());
		
		System.out.println("ɾ����һ��Ԫ�أ�" + citySet.pollFirst());
	}
	
	
	public static void HashSetDemo() {
		Set<String> citySet = new HashSet<>();
		citySet.add("London");
		citySet.add("Parise");
		citySet.add("New York");
		citySet.add("Bei Jing");
		citySet.add("Shang Hai");
		citySet.forEach(str -> System.out.println(str + ",   "));
		
	}
	
	
	public static void LinkedHashSetDemo() {
		Set<String> citySet = new LinkedHashSet<>();
		citySet.add("London");
		citySet.add("Parise");
		citySet.add("New York");
		citySet.add("Bei Jing");
		citySet.add("Shang Hai");
		citySet.forEach(str -> System.out.println(str + ",   "));
	}
}
