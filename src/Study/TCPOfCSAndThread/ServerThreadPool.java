/**  
* <p>Title: ServerThreadPool.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Mar 30, 2019  
* @version 1.0  
*/ 
package Study.TCPOfCSAndThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  
* <p>Title: ServerThreadPool</p>  
* <p>Description: </p>  
* @author 马坤  
* @date Mar 30, 2019  
*/
public class ServerThreadPool {
	public static void main(String[] args) {
		ServerSocket server = null; // 用于监听网络通信服务
		Socket socket = null;
		ExecutorService threadPool = null;
		try {
			server = new ServerSocket(8080); // 绑定网络通信端口
			threadPool = Executors.newCachedThreadPool();
			while (true) { // 让代码可以持续执行
				socket = server.accept();
				STP stp = new STP(socket);
				threadPool.execute(stp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				threadPool.shutdown();
				socket.close(); //
				server.close(); // 释放网卡资源
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class STP implements Runnable{
	Socket socket;
	public STP(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			InputStream in = socket.getInputStream(); // 通过网络通信对象获取网络输入流
			byte[] data = new byte[100]; // 读取网卡数据
			in.read(data);
			String str = new String(data, 0, data.length); // 将字节数据还原成字符串数据
			System.out.println(str);
			// 服务端发送数据1、获取输出流
			OutputStream out = socket.getOutputStream();
			// 通过服务端 //发送数据
			out.write("收到".getBytes());
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
