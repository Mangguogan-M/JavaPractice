package Study.FileIOOption;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * ʹ���ַ������ļ����л����Ĳ���
 * @author ����
 *
 */
public class ReaderAndWriterDemo {
	private static final String FilePath1 = "src/Chapter13/FileDemo1.java";
	private static final String FilePath2 = "src/Chapter13/FileDemo1.java";
	
	public static void main(String[] args) {
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(FilePath1));
			String line = null;
			while((line = bReader.readLine()) != null) {
				System.out.println(line);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
