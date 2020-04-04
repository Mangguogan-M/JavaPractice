/**  
* <p>Title: Server.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Mar 30, 2020</p>  
* @author ����  
* @date Mar 30, 2020  
* @version 1.0  
*/ 
package Study.AIOBIONIO.NIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server implements Runnable{

	private Selector selector;
	
	private ByteBuffer readBuf = ByteBuffer.allocate(1024);
	private ByteBuffer writeBuf = ByteBuffer.allocate(1024);
	
	public Server(int port) {
		try {
			//�򿪶�·������
			this.selector = Selector.open();
			//�򿪷�����ͨ��
			ServerSocketChannel ssc = ServerSocketChannel.open();
			//���÷�����ͨ��Ϊ������ģʽ
			ssc.configureBlocking(false);
			//�󶨵�ַ
			ssc.bind(new InetSocketAddress(port));
			//�ѷ�����ͨ��ע�ᵽ��ַ�ϣ������������¼�
			ssc.register(this.selector, SelectionKey.OP_ACCEPT);
			
			System.out.println("Server start, port : " + port);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		while (true) {
			try {
				this.selector.select();
				//���ض�·�������Ѿ�ѡ��Ľ����
				Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();
				//����
				while (keys.hasNext()) {
					//��Ŷȥһ��ѡ���Ԫ��
					SelectionKey key = keys.next();
					//ֱ�Ӵ��������Ƴ�
					keys.remove();
					//�������Ч��
					if (key.isValid()) {
						//���Ϊ����״̬
						if (key.isAcceptable()) {
							this.accpt(key);
						}
						//���Ϊ�ɶ�״̬
						if (key.isReadable()) {
							this.read(key);
						}
						//���Ϊ��д״̬
						if (key.isWritable()) {
//							this.write(key);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
 
	private void read(SelectionKey key) {
		try {
			//��ջ�����������
			this.readBuf.clear();
			//��ȡ֮ǰע���socket����
			SocketChannel sc = (SocketChannel) key.channel();
			//��ȡ����
			int count = sc.read(this.readBuf);
			//���û������
			if (count == -1) {
				key.channel().close();
				key.cancel();
				return;
			}
			//����������ж�ȡ����ȡ֮ǰ��Ҫ�Ƚ��и�λ��
			this.readBuf.flip();
			//���ݻ����������ݳ��ȴ�����Ӧ��С�����飬���ջ���������
			byte[] bytes = new byte[this.readBuf.remaining()];
			//���ջ���������
			this.readBuf.get(bytes);
			//��ӡ���
			String body = new String(bytes).trim();
			System.out.println("Server : " + body);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void accpt(SelectionKey key) {
		try {
			//��ȡ����ͨ��
			ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
			//ִ����������
			SocketChannel sc = ssc.accept();
			//��������ģʽ
			sc.configureBlocking(false);
			//ע�ᵽ��·�������ϣ������ö�ȡ��ʶ
			sc.register(this.selector, SelectionKey.OP_READ);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Thread(new Server(8765)).start();
	}
	

}
