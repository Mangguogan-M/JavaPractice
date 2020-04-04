package Study.FileIOOption;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 使用带缓存的流来增加读写效率
 * @author 马坤
 *
 */
public class BufferedStreamDemo {
	private static final String FilePath1 = "D:/CloudMusic/买辣椒也用券 - 起风了（Cover 高橋優）.mp3";
	private static final String FilePath2 = "D:/CloudMusic/以复制的文件.mp3";
	
	public static void main(String[] args){
//		//使用缓存流装饰系统的输入流对象
//		BufferedInputStream inStream = new BufferedInputStream(System.in);
//		byte[] bytes = new byte[200];
//		System.out.println("请输入信息：");
//		inStream.read(bytes);
//		System.out.println("输入的信息：" + new String(bytes));
		
		long time = CopyFileByBufferedStream();
		System.out.println("拷贝用时：" + time + "毫秒");
		
	}
	
	
	private static long CopyFileByBufferedStream() {
		File file = new File(FilePath1);
		if (!file.exists()) {
			System.out.println("文件不存在，赋值失败！");
			return 0;
		}
		long starTime = System.currentTimeMillis();
		InputStream inStream = null;
		BufferedInputStream bInStream = null;
		OutputStream outStream = null;
		BufferedOutputStream bOutStream = null;
		try {
			inStream = new FileInputStream(file);
			bInStream = new BufferedInputStream(inStream);
			outStream = new FileOutputStream(FilePath2);
			bOutStream = new BufferedOutputStream(bOutStream);
			int i = -1;
			while((i = bInStream.read()) != -1) {
				bOutStream.write(i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				//bOutStream.flush();
				bOutStream.close();
				outStream.close();
				bInStream.close();
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		long endTime = System.currentTimeMillis();
		return endTime - starTime;
	}
	
	
	
	
//	private static final String filePath1 = "src/Chapter13/FileDemo.java";
//	private static final String filePath2 = "src/Chapter13/BufferedText.txt";
//	public static void main(String[] args) {
//		BufferedInputStream bInputStream = null;
//		FileInputStream fInputStream = null;
//		try {
//			fInputStream = new FileInputStream(filePath1);
//			bInputStream = new BufferedInputStream(fInputStream);
//			byte[] bytes = new byte[bInputStream.available()];
//			bInputStream.read(bytes);
//			System.out.println(new String(bytes));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				bInputStream.close();
//				fInputStream.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		BufferedOutputStream bOutStream = null;
//		try {
//			bOutStream = new BufferedOutputStream(new FileOutputStream(filePath2), 10240);
//			bOutStream.write("今天天气不错哟。。".getBytes());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				bOutStream.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}

}
