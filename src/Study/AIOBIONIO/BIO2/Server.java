/**  
* <p>Title: Server.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Mar 30, 2020</p>  
* @author 马坤  
* @date Mar 30, 2020  
* @version 1.0  
*/ 
package Study.AIOBIONIO.BIO2;
//伪异步
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.spec.ECField;

public class Server {
	
	final static int PROT = 8765;
	
	public static void main(String[] args) {
		
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(PROT);
			System.out.println(" server start .. ");
			//进行阻塞
			Socket socket =null; 
			HandlerExecutorPool executorPool = new HandlerExecutorPool(50, 1000);
			while (true) {
				server.accept();
				executorPool.execute(new ServerHandler(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			server = null;
		}
	}

}
