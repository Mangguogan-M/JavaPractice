package Study.ListSetMapVectorEtc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * 
 * @author 马坤
 *
 */
public class MapDemo {
	public static void main(String[] args) {
		//Map的基本用法();
		
		统计关键字出现的次数();
	}
	
	public static void 统计关键字出现的次数() {
		final String fileName = "src/Chapter14/MapDemo.java";
		final String keywords = "package, import, public, class, void, final, static, new, while, if, catch, for, try, return";
		
		List<String> contentList = ReadSourceFile(fileName);
		Set<String> keywordsSet = new HashSet<>();
		keywordsSet.addAll(Arrays.asList(keywords.split(",")));
		
		Map<String, Integer> keywordsMap = new HashMap<>();
		
		for(String keyword : keywordsSet) {
			keyword = keyword.trim();
			for(String line : contentList) {
				int count = getLineKeywordCount(line, keyword);
				if(count == 0) continue;
				if (keywordsMap.containsKey(keyword)) {
					int oldCount = keywordsMap.get(keyword).intValue();
					keywordsMap.put(keyword, new Integer(oldCount) + count);
				}else {
					keywordsMap.put(keyword, count);
				}
			}
		}
		
		for(Entry<String, Integer> entry : keywordsMap.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
		//排序显示
//		Map<String, Integer> treeMap = new TreeMap<>(new MyTreeComparator(keywordsMap));
//		treeMap.putAll(keywordsMap);
//		for(Entry<String, Integer> entry : treeMap.entrySet()) {
//			System.out.println(entry.getKey() + "\t" + entry.getValue());
//		}
		
//		for(String str : contentList) {
//			System.out.println(str);
//		}
	}
	
	private static int getLineKeywordCount(String line, String keyword) {
		if(null == line || line.length() == 0) return 0;
		if (line.startsWith("/*") || line.startsWith("*") || line.startsWith("*/") || line.startsWith("//")) {
			return 0;
		}
		int count = 0;
		String strLine = new String(line);
		int index = -1;
		while((index = strLine.indexOf(keyword)) != -1) {
			count++;
			strLine = strLine.substring(index + keyword.length() + 1);
		}
		
		
		return count;
	}
	
	
	private static List<String> ReadSourceFile(String fileName) {
		List<String> contentList = new ArrayList<>();
		try (
				FileReader freader = new FileReader(fileName);
				BufferedReader reader = new BufferedReader(freader);
		){
			String line = null;
			while((line = reader.readLine()) != null) {
				if(line.trim().length() == 1) continue;
				contentList.add(line.trim());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return contentList;
	}
	
	public static void Map的基本用法() {
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("Monkey·D·Luffy", 18);
		hashMap.put("Nami", 19);
		hashMap.put("Sanji", 25);
		hashMap.put("Nico Robin", 26);
		hashMap.put("Roronoa Zoro", 21);
		System.out.println("hashMap:" + hashMap);
		
		Map<String, Integer> linkedHashMap = new LinkedHashMap<>();		//是插入的顺序
		linkedHashMap.put("Monkey·D·Luffy", 18);
		linkedHashMap.put("Nami", 19);
		linkedHashMap.put("Sanji", 25);
		linkedHashMap.put("Nico Robin", 26);
		linkedHashMap.put("Roronoa Zoro", 21);
		System.out.println("linkedHashMap:" + linkedHashMap);
		
		Map<String, Integer> treeMap = new TreeMap<>(new MyTreeComparator());
		treeMap.put("Monkey·D·Luffy", 18);
		treeMap.put("Nami", 19);
		treeMap.put("Sanji", 25);
		treeMap.put("Nico Robin", 26);
		treeMap.put("Roronoa Zoro", 21);
		System.out.println("treeMap:" + treeMap);
		
		
		
		
		System.out.println("第一种遍历方式：通过Map.KeySet遍历key，通过kry去除对应的value");
		for (String key : treeMap.keySet()) {
			System.out.println(key + " -- " + treeMap.get(key));
		}
		
		System.out.println("第二种遍历方式：");
		Set<Map.Entry<String, Integer>> entrySet = treeMap.entrySet();
		Iterator<Map.Entry<String, Integer>> entrySetIt = entrySet.iterator();
		while(entrySetIt.hasNext()) {
			Map.Entry<String, Integer> entry = entrySetIt.next();
			System.out.println(entry.getKey() + "\t\t" + entry.getValue());
		}
		
		
		System.out.println("第三种方式：");
		for(Entry<String, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + "----" + entry.getValue());
		}
		
		
		
		
		
	}
}


class MyTreeComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if(o1.compareTo(o2) > 0)return -1;
		if(o1.compareTo(o2) < 0)return 1;
		return 0;
	}
	
}