/**  
* <p>Title: Server.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author ¬Ì¿§  
* @date Apr 20, 2019  
* @version 1.0  
*/ 
package Study.SimpleFileIOOption;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.crypto.Data;

public class Server {
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			server = new ServerSocket(8080);
			socket = server.accept();
			bis = new BufferedInputStream(socket.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream("qwer1.txt"));
			long starTime = System.currentTimeMillis();
			int data = -1;
			while((data = bis.read()) != -1) {
				bos.write(data);
			}
			long endTime = System.currentTimeMillis();
			System.out.println("∫ƒ ±£∫" + (endTime - starTime) +"∫¡√Î");
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				bos.flush();
				bos.close();
				bis.close();
				socket.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
