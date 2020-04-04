package Study.TCPOfCSAndThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @author 马坤
 *
 *         用户端
 */
public class Client {
	public static void main(String[] args) {
		// 1、给服务端发送链接请求
		// 直接发送网络链接对象
		Socket socket = null;
		try {
			while (true) {
				socket = new Socket("192.168.0.109", 8080);
				String str = "为你我受冷风吹";
				OutputStream out = socket.getOutputStream(); // 获取输出流
				out.write(str.getBytes()); // 写出数据，写出到网卡
				InputStream in = socket.getInputStream(); // 客户端获取数据，
				// 读取数据并还原
				byte[] data = new byte[100];
				in.read(data);
				str = new String(data, 0, data.length);
				System.out.println(str);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
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
