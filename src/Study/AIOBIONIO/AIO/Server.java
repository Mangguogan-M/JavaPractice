/**  
* <p>Title: Server.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Mar 30, 2020</p>  
* @author ����  
* @date Mar 30, 2020  
* @version 1.0  
*/ 
package Study.AIOBIONIO.AIO;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	//�̳߳�
	private ExecutorService executorService;
	//�߳���
	private AsynchronousChannelGroup threadGroup;
	//������ͨ��
	public AsynchronousServerSocketChannel assc;
	
	public Server(int port) {
		try {
			//����һ�������
			executorService = Executors.newCachedThreadPool();
			//�����߳���
			threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
			//����������ͨ��
			assc = AsynchronousServerSocketChannel.open(threadGroup);
			//���а�
			assc.bind(new InetSocketAddress(port));
			
			System.out.println("server start , port : " + port);
			//��������
			assc.accept(this, new ServerCompletionHandler());
			//һֱ�������÷�����ֹͣ
			Thread.sleep(Integer.MAX_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server server = new Server(8765);
	}
}
