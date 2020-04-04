/**  
* <p>Title: ServerCompletionHandler.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Mar 30, 2020</p>  
* @author ����  
* @date Mar 30, 2020  
* @version 1.0  
*/ 
package Study.AIOBIONIO.AIO;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ServerCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, Server> {

	
	@Override
	public void completed(AsynchronousSocketChannel asc, Server attachment) {
		//����һ���ͻ��˽����ʱ��ֱ�ӵ���server��accept��������������ִ����ȥ����֤����û�����������
		attachment.assc.accept(attachment, this);
		read(asc);
	}

	@Override
	public void failed(Throwable exc, Server attachment) {
		exc.printStackTrace();
	}
	
	private void read(final AsynchronousSocketChannel asc) {
		//��ȡ����
		ByteBuffer buf = ByteBuffer.allocate(1024);
		asc.read(buf, buf, new CompletionHandler<Integer, ByteBuffer>() {

			@Override
			public void completed(Integer result, ByteBuffer attachment) {
				//��λ
				attachment.flip();
				System.out.println("Server -> " + "�յ��ͻ��˵����ݳ���Ϊ��" + result);
				String resultData = new String(attachment.array()).trim();
				System.out.println("Server -> " + "�յ��ͻ��˵�����Ϊ��" + resultData);
				String response = "��������Ӧ���յ��ͻ��˷��������ݣ�" + resultData;
				write(asc, response);
			}

			@Override
			public void failed(Throwable exc, ByteBuffer attachment) {
				exc.printStackTrace();
			}
		});
	}
 
	protected void write(AsynchronousSocketChannel asc, String response) {
		try {
			ByteBuffer buf = ByteBuffer.allocate(1024);
			buf.put(response.getBytes());
			buf.flip();
			asc.write(buf).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
