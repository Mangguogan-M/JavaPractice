package Study.FileIOOption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamDemo {
	private static final String FilePath = "";
	public static void main(String[] args) throws IOException {
		//ReadFile();
		writeFile();
	}
	
	public static void writeFile() throws IOException {
		final String FilePath1 = "";
		OutputStream outStream = new FileOutputStream(FilePath1);
		String content = "nihaoa zhognguo";
		outStream.write(content.getBytes());//核心语句：将字符串转换成字节数组
		outStream.close();
	}
	
	
	
	public static void ReadFile() throws IOException {
		File file = new File(FilePath);
		InputStream inputStream = new FileInputStream(file);
		//读取文件的操作相对固定
		byte[] bytes = new byte[20000];
		inputStream.read(bytes);
//		int count = 0;
//		while((bytes[count] = (byte)inputStream.read()) != -1) {
//			count++;
//		}
		String content = new String(bytes);//将读取出来的字节数组转换成字符串，一边打印
		System.out.println(content);
		inputStream.close();
	}
	
}
