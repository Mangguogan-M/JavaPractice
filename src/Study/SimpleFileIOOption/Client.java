/**  
* <p>Title: Client.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Apr 20, 2019  
* @version 1.0  
*/ 
package Study.SimpleFileIOOption;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**  
* <p>Title: Client</p>  
* <p>Description: </p>  
* @author 马坤  
* @date Apr 20, 2019  
*/
public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		try {
			socket = new Socket("localhost", 8080);
			bos = new BufferedOutputStream(socket.getOutputStream());
			bis = new BufferedInputStream(new FileInputStream("789.txt"));
			int data = -1;
			while((data = bis.read()) != -1) {//从文件中读取字节
				bos.write(data);//向网卡中写数据
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bis.close();
				bos.flush();
				bos.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
