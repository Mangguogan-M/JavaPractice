package Study.ListSetMapVectorEtc;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class CollectionDemo {

	public static void main(String[] args) {
		java.util.List<String> list1 = new ArrayList<>();
		list1.add("�ܲ�");
		list1.add("��ֲ");
		list1.add("�ܳ�");
		list1.add("��ا");
		list1.add("����");
		System.out.println(list1);
		list1.add(1, "������");
		System.out.println(list1);
		list1.set(1, "���Ƴ�");
		System.out.println(list1);
		
		java.util.List<String> list2 = new ArrayList<>();
		list2.add("�����");
		list2.add("�ŷ���");
		
		list1.addAll(list2);
		System.out.println(list1);
		
		System.out.println("���ϵı���");
		//1��
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + ", ");
		}
		System.out.println();
		//2��
		for(String str : list1) {
			System.out.print(str + ", ");
		}
		System.out.println();
		//3��
		Iterator<String> it = list1.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		System.out.println();
		//4��
		ListIterator<String> listIt = list1.listIterator();
		while(listIt.hasNext()) {
			System.out.print(listIt.next() + ", ");
		}
		System.out.println();
		
		//listiterator��֪���������ʣ�Ҳ������ǰ
		//�����޸ļ����е�Ԫ��
		//����
		System.out.println("����");
		ListIterator<String> listIt2 = list1.listIterator(list1.size());
		while(listIt2.hasPrevious()) {
			System.out.print(listIt2.previous() + ", ");
		}
		System.out.println();
		
		ListIterator<String> listIt3 = list1.listIterator(list1.size());
		if (listIt3.hasPrevious()) {
			listIt3.previous();
			listIt3.set("������");
		}
		System.out.println(list1);
		

	}

}
