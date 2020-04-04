package Study.ListSetMapVectorEtc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsDemo {

	public static void main(String[] args) {
		List<Integer> intCollection = new ArrayList<>();
		intCollection.add(123);
		intCollection.add(120);
		intCollection.add(124);
		intCollection.add(122);
		intCollection.add(127);
		intCollection.add(126);

		intCollection.forEach(value -> System.out.print(value + ",  "));
		Collections.shuffle(intCollection, new Random(20));		//乱序的做法
		System.out.println("\n乱序后：");
		intCollection.forEach(value -> System.out.print(value + ",  "));
		
		System.out.println("集合的capy");
		List<Integer> longCollection = new ArrayList<>();
		longCollection.add(0);
		longCollection.add(1);
		longCollection.add(1);
		longCollection.add(12);
		longCollection.add(7);
		longCollection.add(6);
		Collections.copy(longCollection, intCollection);
		longCollection.forEach(value -> System.out.print(value + ",  "));
	}

}
