/**  
* <p>Title: ChatServer.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Mar 23, 2020</p>  
* @author 马坤  
* @date Mar 23, 2020  
* @version 1.0  
*/
package LittleDemo.SimpleChat;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.PortableInterceptor.DISCARDING;

public class ChatServer {
	boolean started = false;
	ServerSocket ss = null;

	public static void main(String[] args) {
		new ChatServer().start();
	}

	public void start() {
		try {
			ss = new ServerSocket(8888);
			started = true;
		} catch (BindException e) {
			System.out.println("服务器正在运行中。");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			
			while (started) {
				Socket s = ss.accept();
				Client c = new Client(s);
				System.out.println(" a client connected ");
				new Thread(c).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class Client implements Runnable {
		private Socket s;
		private DataInputStream dis = null;
		private boolean bConnected = false;

		public Client(Socket s) {
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream());
				bConnected = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				while (bConnected) {
					String str = dis.readUTF();
					System.out.println(str);
				}
			} catch (EOFException e) {
				System.out.println("client closed");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (dis != null)
						dis.close();
					if (s != null)
						s.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}
