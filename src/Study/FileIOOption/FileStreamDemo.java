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
		outStream.write(content.getBytes());//������䣺���ַ���ת�����ֽ�����
		outStream.close();
	}
	
	
	
	public static void ReadFile() throws IOException {
		File file = new File(FilePath);
		InputStream inputStream = new FileInputStream(file);
		//��ȡ�ļ��Ĳ�����Թ̶�
		byte[] bytes = new byte[20000];
		inputStream.read(bytes);
//		int count = 0;
//		while((bytes[count] = (byte)inputStream.read()) != -1) {
//			count++;
//		}
		String content = new String(bytes);//����ȡ�������ֽ�����ת�����ַ�����һ�ߴ�ӡ
		System.out.println(content);
		inputStream.close();
	}
	
}
