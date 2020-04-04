package Study.TCPOfCSAndThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Title: ServerThread
 * Description:
 * @author ����
 * @date Mar 23, 2019
 */
public class ServerThread {
	public static void main(String[] args) {
		ServerSocket server = null; // ���ڼ�������ͨ�ŷ���
		Socket socket = null;
		try {
			server = new ServerSocket(8080); // ������ͨ�Ŷ˿�
			while (true) { // �ô�����Գ���ִ��
				socket = server.accept();
				ST st = new ST(socket);
				st.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close(); //
				server.close(); // �ͷ�������Դ
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class ST extends Thread {
	public Socket socket;

	public ST(Socket socket) {
		this.socket = socket;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
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
