package Study.ListSetMapVectorEtc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAndLingkedList {

	public static void main(String[] args) {
		System.out.println("ArrayList��ʱ��" + CostTime(new ArrayList<>()));
		System.out.println("LinkedList��ʱ��" + CostTime(new LinkedList<>()));
	}
	public static long CostTime(List<Object> list) {
		Object obj = new Object();
		final int N = 5000;
		long starTime = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			list.add(0, obj);
		}
		long endTime = System.currentTimeMillis();
		return endTime - starTime;
	}
}
