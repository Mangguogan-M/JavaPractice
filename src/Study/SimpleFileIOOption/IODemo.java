/**  
* <p>Title: IODemo.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Apr 13, 2019  
* @version 1.0  
*/ 
package Study.SimpleFileIOOption;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.junit.Test;


/*
 * org.junit.test��ר�����ڽ��г�����Ե�(Ҫ���޲ε�)
 * ����ͬʱ���Զ��������Ҳ���Ը���ѡ�еķ�������������
 */
public class IODemo {
	@Test
	public void test0() {
		System.out.println("LCK����");
	}
	@Test
	public void test1() {
		System.out.println("SKT vs GRF");
	}
	/*
	 * IO��
	 * Java�����е���������ķ�������������Ϊ������
	 * inputstream �ֽ�������
	 * outputstream�ֽ������
	 * �ֽ�IO���Ķ�������
	 * �ļ�IO��
	 * �ļ����ݶ�ȡ��
	 * FileInputStream �ļ��ֽ�������
	 * read�������ȡĿ���ļ�һ���ֽڣ�������ĩβʱ����-1
	 * 
	 */
	@Test
	public void testFileRead() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("1.txt");
			int data = 0;
			while ((data = fis.read()) != -1) {
				char ch = (char)data;
				System.out.println(ch);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/*
	 * FileOutputStream�ļ��ֽ������
	 * write(byte[] data)���������ڽ�һ�ֽ������Ŀ��λ��
	 * write(int data)���ڽ�һ���ֽ�д�뵽Ŀ��λ��
	 */
	@Test
	public void testFileWrite() {
		FileOutputStream fos = null;
		try {
//			fos = new FileOutputStream("1.txt");���õ��Ǹ���д����ʽ
			fos = new FileOutputStream("1.txt", true);//����׷��д����ʽ
			String str = "LCK��ʼ��";
			byte[] data = str.getBytes();
			fos.write(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/*
	 * �ļ�����
	 */
	@Test
	public void testCopy() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("1.txt");
			fos = new FileOutputStream("2.txt");
			int data = -1;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	//�ֶ�����һ��1m���ļ�
	@Test
	public void testNewFile() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("789.txt");
			for (int i = 0; i < 1024*1024; i++) {
				fos.write(i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//ʱ����ԣ������ļ�
	@Test
	public void testCopyTime() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("789.txt");
			fos = new FileOutputStream("qwer.txt");
			long time = System.currentTimeMillis();
			int data = -1;
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
			long time0 = System.currentTimeMillis();
			System.out.println("��ʱ��"+ (time0-time) + "����");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * io���з�Ϊ�߼����͵ͼ���
	 * �߼���Ҳ�д�����
	 * ���ڲ����ֽ����ݵ�����Ϊ�ͼ���
	 * �߼������ڽ��ͼ������з�װ�����
	 * �����ֽ���bufferedinputstream��bufferedoutputstream
	 */
	@Test
	public void testBufferedCopy() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			fis = new FileInputStream("789.txt");
			bufferedInputStream = new BufferedInputStream(fis);
			fos = new FileOutputStream("qwer0.txt");
			bufferedOutputStream = new BufferedOutputStream(fos);
			long time = System.currentTimeMillis();
			int data = -1;
			while((data = bufferedInputStream.read()) != -1) {
				bufferedOutputStream.write(data);
			}
			long time0 = System.currentTimeMillis();
			System.out.println("��ʱ��"+ (time0-time) + "����");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bufferedInputStream.close();
				fis.close();
				bufferedOutputStream.flush();
				bufferedOutputStream.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * �ַ���
	 * Reader
	 * Writer
	 * �������Ƕ�������
	 * ��õ�BufferedReader�����ַ���
	 * ���·�����Ҫ����һ��ֱ�ӻ��߼�Ӽ̳�Reader�������Զ���
	 * inputstreamReader�����ñ�����ַ�������
	 * ���췽����Ҫ����һ���ֽ���
	 * ������ñ���
	 * �����ַ�������ʽ����ڶ�������
	 * radline����
	 * ���ȡĿ��λ��һ���ַ�
	 * ��\��\r\nΪ��β��Ĭ��Ϊһ���ַ�
	 * \r���з�
	 * \n�س���
	 * ��ȡ��Ŀ��λ�ý�β���᷵��null
	 * ���򷵻�ֵ��Ϊ�ַ���
	 */
	@Test
	public void testBufferedReader() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(
				new InputStreamReader(new FileInputStream("123.txt"), "GBK")
			);
			String str = null;
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
