package Study.TCPOfCSAndThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @author ����
 *
 *         �û���
 */
public class Client {
	public static void main(String[] args) {
		// 1��������˷�����������
		// ֱ�ӷ����������Ӷ���
		Socket socket = null;
		try {
			while (true) {
				socket = new Socket("192.168.0.109", 8080);
				String str = "Ϊ��������紵";
				OutputStream out = socket.getOutputStream(); // ��ȡ�����
				out.write(str.getBytes()); // д�����ݣ�д��������
				InputStream in = socket.getInputStream(); // �ͻ��˻�ȡ���ݣ�
				// ��ȡ���ݲ���ԭ
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
