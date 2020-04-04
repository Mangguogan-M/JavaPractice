package Study.TCPOfCSAndThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP/IP协议 有链接的网络协议（类似于现实生活中的电话服务） 通信过程要求：客户端先于服务端建立连接，然后才能进行数据传递
 * 
 * @author 马坤
 *
 *         服务端程序设计
 */
public class Server {
	public static void main(String[] args) {
		ServerSocket server = null; // 用于监听网络通信服务
		Socket socket = null;
		try {
			server = new ServerSocket(8080); // 绑定网络通信端口
			while (true) {		//让代码可以持续执行
				socket = server.accept(); // 监听网络通信，如果没有通信链接，accept方法会一直等待，知道有通信链接后才会继续运行
				// 4.通过网络通信对象获取网络输入流
				InputStream in = socket.getInputStream();
				// 5.读取网卡数据
				byte[] data = new byte[100];
				in.read(data);
				// 6.将字节数据还原成字符串数据
				String str = new String(data, 0, data.length);
				System.out.println(str);
				// 服务端发送数据
				// 1.获取输出流
				OutputStream out = socket.getOutputStream();
				// 2.发送数据
				out.write("收到".getBytes());
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();	//
				server.close(); // 释放网卡资源
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
