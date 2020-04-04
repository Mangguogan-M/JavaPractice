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
 * ʹ�ô�������������Ӷ�дЧ��
 * @author ����
 *
 */
public class BufferedStreamDemo {
	private static final String FilePath1 = "D:/CloudMusic/������Ҳ��ȯ - ����ˣ�Cover �ߘ򃞣�.mp3";
	private static final String FilePath2 = "D:/CloudMusic/�Ը��Ƶ��ļ�.mp3";
	
	public static void main(String[] args){
//		//ʹ�û�����װ��ϵͳ������������
//		BufferedInputStream inStream = new BufferedInputStream(System.in);
//		byte[] bytes = new byte[200];
//		System.out.println("��������Ϣ��");
//		inStream.read(bytes);
//		System.out.println("�������Ϣ��" + new String(bytes));
		
		long time = CopyFileByBufferedStream();
		System.out.println("������ʱ��" + time + "����");
		
	}
	
	
	private static long CopyFileByBufferedStream() {
		File file = new File(FilePath1);
		if (!file.exists()) {
			System.out.println("�ļ������ڣ���ֵʧ�ܣ�");
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
//			bOutStream.write("������������Ӵ����".getBytes());
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
