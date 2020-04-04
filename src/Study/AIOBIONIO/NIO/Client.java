/**  
* <p>Title: Client.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Mar 30, 2020</p>  
* @author ����  
* @date Mar 30, 2020  
* @version 1.0  
*/ 
package Study.AIOBIONIO.NIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
	public static void main(String[] args) {
		//�������ӵĵ�ַ
		InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8765);
		//��������ͨ��
		SocketChannel sc = null;
		//����������
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		try {
			//��ͨ��
			sc = SocketChannel.open();
			//��������
			sc.connect(address);
			while (true) {
				//����һ���ֽ����飬Ȼ��ʹ��ϵͳ¼�빦��
				byte[] bytes = new byte[1024];
				System.in.read(bytes);
				//�����ݷŵ�������
				buf.put(bytes);
				//�Ի��������ݸ�λ
				buf.flip();
				//д������
				sc.write(buf);
				//��ջ�����
				buf.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (sc != null) {
				try {
					sc.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
