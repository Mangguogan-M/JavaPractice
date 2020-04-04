/**  
* <p>Title: Server.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Mar 30, 2020</p>  
* @author ÂíÀ¤  
* @date Mar 30, 2020  
* @version 1.0  
*/ 
package Study.AIOBIONIO.BIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	final static int PROT = 8765;
	
	public static void main(String[] args) {
		
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(PROT);
			System.out.println(" server start .. ");
			//½øÐÐ×èÈû
			Socket socket = server.accept();
			new Thread(new ServerHandler(socket)).start();
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
