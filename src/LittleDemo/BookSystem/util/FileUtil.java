package LittleDemo.BookSystem.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import LittleDemo.BookSystem.entity.BookInfo;

public class FileUtil {

	private static final String BookInfoFilePath = "BookInfo.dat";
	/**
	 * 将你传入的
	 * @param bookInfoMap
	 */
	public static void SaveBookInfoMap(Map<String, BookInfo> bookInfoMap) {
		SaveObject(bookInfoMap, BookInfoFilePath);
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, BookInfo> ReadBookInfoMap(){
		Object obj = ReadObject(BookInfoFilePath);
		if(null == obj) return null;
		return (Map<String, BookInfo>)obj;
	}
	
	
	public static void SaveObject(Object object, String filePath) {
		try (
			FileOutputStream fout = new FileOutputStream(filePath);
			ObjectOutputStream out = new ObjectOutputStream(fout);
		){
			out.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object ReadObject(String filePath) {
		try (
			FileInputStream fin = new FileInputStream(filePath);
			ObjectInputStream in = new ObjectInputStream(fin);
		){
			return in.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
