/**  
* <p>Title: HandlerExecutorPool.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) Mar 30, 2020</p>  
* @author ÂíÀ¤  
* @date Mar 30, 2020  
* @version 1.0  
*/ 
package Study.AIOBIONIO.BIO2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HandlerExecutorPool {
	
	private ExecutorService executor;
	public HandlerExecutorPool(int maxPoolSize, int queueSize) {
		this.executor = new ThreadPoolExecutor(
				Runtime.getRuntime().availableProcessors(),
				maxPoolSize,
				120L,
				TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(queueSize));
	}
	
	public void execute(Runnable task) {
		this.executor.execute(task);
	}
}
