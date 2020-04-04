package Study.TCPOfCSAndThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP/IPЭ�� �����ӵ�����Э�飨��������ʵ�����еĵ绰���� ͨ�Ź���Ҫ�󣺿ͻ������ڷ���˽������ӣ�Ȼ����ܽ������ݴ���
 * 
 * @author ����
 *
 *         ����˳������
 */
public class Server {
	public static void main(String[] args) {
		ServerSocket server = null; // ���ڼ�������ͨ�ŷ���
		Socket socket = null;
		try {
			server = new ServerSocket(8080); // ������ͨ�Ŷ˿�
			while (true) {		//�ô�����Գ���ִ��
				socket = server.accept(); // ��������ͨ�ţ����û��ͨ�����ӣ�accept������һֱ�ȴ���֪����ͨ�����Ӻ�Ż��������
				// 4.ͨ������ͨ�Ŷ����ȡ����������
				InputStream in = socket.getInputStream();
				// 5.��ȡ��������
				byte[] data = new byte[100];
				in.read(data);
				// 6.���ֽ����ݻ�ԭ���ַ�������
				String str = new String(data, 0, data.length);
				System.out.println(str);
				// ����˷�������
				// 1.��ȡ�����
				OutputStream out = socket.getOutputStream();
				// 2.��������
				out.write("�յ�".getBytes());
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();	//
				server.close(); // �ͷ�������Դ
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
