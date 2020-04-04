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
 * org.junit.test是专门用于进行程序测试的(要求无参的)
 * 可以同时测试多个方法，也可以根据选中的方法名单个测试
 */
public class IODemo {
	@Test
	public void test0() {
		System.out.println("LCK决赛");
	}
	@Test
	public void test1() {
		System.out.println("SKT vs GRF");
	}
	/*
	 * IO流
	 * Java中所有的输入输出的反方向都是依程序为出发点
	 * inputstream 字节输入流
	 * outputstream字节输出流
	 * 字节IO流的顶级父类
	 * 文件IO流
	 * 文件数据读取流
	 * FileInputStream 文件字节输入流
	 * read方法会读取目标文件一个字节，当读到末尾时返回-1
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
	 * FileOutputStream文件字节输出流
	 * write(byte[] data)方法，用于将一字节输出到目标位置
	 * write(int data)用于将一个字节写入到目标位置
	 */
	@Test
	public void testFileWrite() {
		FileOutputStream fos = null;
		try {
//			fos = new FileOutputStream("1.txt");采用的是覆盖写的形式
			fos = new FileOutputStream("1.txt", true);//这是追加写的形式
			String str = "LCK开始了";
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
	 * 文件复制
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
	//手动生成一个1m的文件
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
	//时间测试，复制文件
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
			System.out.println("耗时："+ (time0-time) + "毫秒");
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
	 * io流中分为高级流和低级流
	 * 高级流也叫处理流
	 * 用于操作字节数据的流称为低级流
	 * 高级流用于将低级流进行封装处理的
	 * 缓冲字节流bufferedinputstream和bufferedoutputstream
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
			System.out.println("耗时："+ (time0-time) + "毫秒");
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
	 * 字符流
	 * Reader
	 * Writer
	 * 这两个是顶级父类
	 * 最常用的BufferedReader缓冲字符流
	 * 狗奥方法中要求传入一个直接或者间接继承Reader类的子类对对象
	 * inputstreamReader可设置编码的字符输入流
	 * 构造方法中要求传入一个字节流
	 * 如果设置编码
	 * 则以字符串的形式传入第二个参数
	 * radline方法
	 * 会读取目标位置一行字符
	 * 以\人\r\n为结尾则默认为一行字符
	 * \r换行符
	 * \n回车符
	 * 读取到目标位置结尾处会返回null
	 * 否则返回值都为字符串
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
