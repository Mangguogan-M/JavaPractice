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
* @author ����  
* @date Mar 30, 2019  
*/
public class ServerThreadPool {
	public static void main(String[] args) {
		ServerSocket server = null; // ���ڼ�������ͨ�ŷ���
		Socket socket = null;
		ExecutorService threadPool = null;
		try {
			server = new ServerSocket(8080); // ������ͨ�Ŷ˿�
			threadPool = Executors.newCachedThreadPool();
			while (true) { // �ô�����Գ���ִ��
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
				server.close(); // �ͷ�������Դ
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
			InputStream in = socket.getInputStream(); // ͨ������ͨ�Ŷ����ȡ����������
			byte[] data = new byte[100]; // ��ȡ��������
			in.read(data);
			String str = new String(data, 0, data.length); // ���ֽ����ݻ�ԭ���ַ�������
			System.out.println(str);
			// ����˷�������1����ȡ�����
			OutputStream out = socket.getOutputStream();
			// ͨ������� //��������
			out.write("�յ�".getBytes());
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
