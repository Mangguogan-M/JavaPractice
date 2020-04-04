/**  
* <p>Title: Server.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 11, 2019</p>  
* @author ����  
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
 * HttpЭ��
 * ����TCP/IPЭ����ж���ĸ�ʽ��װ
 * Http��������
 * ����·����ַ
 * localhost:8080/index.html
 * IP��ַ:localhost
 * �˿ں�:8080
 * ��Դ·��:index.html
 * 1.״̬��
 * ����ʽ ��Դ·�� httpЭ��汾
 * GET/��Դ·��HTTP/1.1
 * 2.��Ϣͷ
 * ��Ҫ����˵���������е�������Ϣ
 * ��Ϣ����������汾,���ӵ�ַ,���ӷ�ʽ
 * 3.��Ϣ����
 * ֻ�а�����ʽΪpost��ʽʱ
 * �Ż�����Ϣ����
 * 
 * Http��Ӧ
 * 1.״̬��
 * Э��汾 ״̬�� ״̬����
 * http/1.1 200 ok
 * 2.��Ϣͷ
 * ��Դ����
 * contentType:text/html
 * ��Դ��С
 * ContentLength
 * 3.����
 * 4.��Դ����
 * ��Ӳ�̶�ȡ��Դ���͸������
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
			 * File����
			 * ר�Ŷ��ļ�������Ӧ�Ĺ���Ͳ���
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
