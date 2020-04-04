/**  
* <p>Title: ServerCompletionHandler.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Mar 30, 2020</p>  
* @author 马坤  
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
		//当有一个客户端接入的时候直接调用server的accept方法，这样反复执行下去，保证多个用户都可以阻塞
		attachment.assc.accept(attachment, this);
		read(asc);
	}

	@Override
	public void failed(Throwable exc, Server attachment) {
		exc.printStackTrace();
	}
	
	private void read(final AsynchronousSocketChannel asc) {
		//读取数据
		ByteBuffer buf = ByteBuffer.allocate(1024);
		asc.read(buf, buf, new CompletionHandler<Integer, ByteBuffer>() {

			@Override
			public void completed(Integer result, ByteBuffer attachment) {
				//复位
				attachment.flip();
				System.out.println("Server -> " + "收到客户端的数据长度为：" + result);
				String resultData = new String(attachment.array()).trim();
				System.out.println("Server -> " + "收到客户端的数据为：" + resultData);
				String response = "服务器相应，收到客户端发来的数据：" + resultData;
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
