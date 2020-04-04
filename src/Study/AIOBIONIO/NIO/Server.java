/**  
* <p>Title: Server.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Mar 30, 2020</p>  
* @author 马坤  
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
			//打开多路复用器
			this.selector = Selector.open();
			//打开服务器通道
			ServerSocketChannel ssc = ServerSocketChannel.open();
			//设置服务器通道为非阻塞模式
			ssc.configureBlocking(false);
			//绑定地址
			ssc.bind(new InetSocketAddress(port));
			//把服务器通道注册到地址上，并监听阻塞事件
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
				//返回多路复用器已经选择的结果集
				Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();
				//遍历
				while (keys.hasNext()) {
					//胡哦去一个选择的元素
					SelectionKey key = keys.next();
					//直接从容器中移除
					keys.remove();
					//如果是有效的
					if (key.isValid()) {
						//如果为阻塞状态
						if (key.isAcceptable()) {
							this.accpt(key);
						}
						//如果为可读状态
						if (key.isReadable()) {
							this.read(key);
						}
						//如果为可写状态
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
			//清空缓冲区的数据
			this.readBuf.clear();
			//获取之前注册的socket对象
			SocketChannel sc = (SocketChannel) key.channel();
			//读取数据
			int count = sc.read(this.readBuf);
			//如果没有数据
			if (count == -1) {
				key.channel().close();
				key.cancel();
				return;
			}
			//有数据则进行读取，读取之前需要先进行复位，
			this.readBuf.flip();
			//根据缓冲区中数据长度创建对应大小的数组，接收缓冲区数据
			byte[] bytes = new byte[this.readBuf.remaining()];
			//接收缓冲区数据
			this.readBuf.get(bytes);
			//打印结果
			String body = new String(bytes).trim();
			System.out.println("Server : " + body);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void accpt(SelectionKey key) {
		try {
			//获取服务通道
			ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
			//执行阻塞方法
			SocketChannel sc = ssc.accept();
			//设置阻塞模式
			sc.configureBlocking(false);
			//注册到多路复用器上，并设置读取标识
			sc.register(this.selector, SelectionKey.OP_READ);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Thread(new Server(8765)).start();
	}
	

}
