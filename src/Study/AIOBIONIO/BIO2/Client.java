/**  
* <p>Title: Client.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Mar 30, 2020</p>  
* @author 马坤  
* @date Mar 30, 2020  
* @version 1.0  
*/ 
package Study.AIOBIONIO.BIO2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	final static String ADDRESS = "127.0.0.1";
	final static int PROT = 8765;
	
	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			socket = new Socket(ADDRESS, PROT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			
			//发送数据
			out.println("接收到客户端请求数据。。。。。");
			String response = in.readLine();
			System.out.println("Client: " + response);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
