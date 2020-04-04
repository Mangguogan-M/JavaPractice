package Study.ListSetMapVectorEtc;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class CollectionDemo {

	public static void main(String[] args) {
		java.util.List<String> list1 = new ArrayList<>();
		list1.add("曹操");
		list1.add("曹植");
		list1.add("曹冲");
		list1.add("曹丕");
		list1.add("曹仁");
		System.out.println(list1);
		list1.add(1, "刘玄德");
		System.out.println(list1);
		list1.set(1, "关云长");
		System.out.println(list1);
		
		java.util.List<String> list2 = new ArrayList<>();
		list2.add("仗义的");
		list2.add("张飞龙");
		
		list1.addAll(list2);
		System.out.println(list1);
		
		System.out.println("集合的便利");
		//1、
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + ", ");
		}
		System.out.println();
		//2、
		for(String str : list1) {
			System.out.print(str + ", ");
		}
		System.out.println();
		//3、
		Iterator<String> it = list1.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		System.out.println();
		//4、
		ListIterator<String> listIt = list1.listIterator();
		while(listIt.hasNext()) {
			System.out.print(listIt.next() + ", ");
		}
		System.out.println();
		
		//listiterator不知可以想后访问，也可以向前
		//可以修改集合中的元素
		//逆序
		System.out.println("逆序：");
		ListIterator<String> listIt2 = list1.listIterator(list1.size());
		while(listIt2.hasPrevious()) {
			System.out.print(listIt2.previous() + ", ");
		}
		System.out.println();
		
		ListIterator<String> listIt3 = list1.listIterator(list1.size());
		if (listIt3.hasPrevious()) {
			listIt3.previous();
			listIt3.set("赵子龙");
		}
		System.out.println(list1);
		

	}

}
