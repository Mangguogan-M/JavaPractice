/**  
* <p>Title: Server.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 11, 2019</p>  
* @author 马坤  
* @date May 11, 2019  
* @version 1.0  
*/ 
package Study.HTTPDec;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Http协议
 * 基于TCP/IP协议进行额外的格式封装
 * Http请求内容
 * 解析路径地址
 * localhost:8080/index.html
 * IP地址:localhost
 * 端口号:8080
 * 资源路径:index.html
 * 1.状态行
 * 请求方式 资源路径 http协议版本
 * GET/资源路径HTTP/1.1
 * 2.消息头
 * 主要用于说明该请求中的配置信息
 * 信息包括浏览器版本,链接地址,链接方式
 * 3.消息内容
 * 只有哎请求方式为post形式时
 * 才会有消息内容
 * 
 * Http响应
 * 1.状态行
 * 协议版本 状态码 状态描述
 * http/1.1 200 ok
 * 2.消息头
 * 资源类型
 * contentType:text/html
 * 资源大小
 * ContentLength
 * 3.空行
 * 4.资源内容
 * 从硬盘读取资源发送给浏览器
 */
public class Server {
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		FileInputStream fis = null;
		try {
			server = new ServerSocket(8080);
			socket = server.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			String str = null;
			str = br.readLine();
			str = str.substring(str.indexOf(" "), str.lastIndexOf(" "));
			OutputStream os = socket.getOutputStream();
			os.write("HTTP/1.1 200 OK\r\n".getBytes());
			os.write("Content-Type:text/html\r\n".getBytes());
			File file = new File("index.html");
			os.write(("Content-Length:" + file.length() + "\n\r").getBytes());
			os.write("\n\r".getBytes());
			fis = new FileInputStream(file);
			int data = -1;
			while((data = fis.read()) != -1) {
				os.write(data);
			}
			/**
			 * File对象
			 * 专门对文件进行响应的管理和操作
			 */
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				socket.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
