/**  
* <p>Title: ThreadPool.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Mar 30, 2019  
* @version 1.0  
*/ 
package Study.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  
* <p>Title: ThreadPool</p>  
* <p>Description: 线程池</p>  
* 是在内存中保存相应数量的线程数
* 用于处理业务，处理完成之后不会销毁
* 而是内存中据徐存在等待之后的业务
* @author 马坤  
* @date Mar 30, 2019  
*/
public class ThreadPool {
	public static void main(String[] args) {
		/**
		 * 创建线程池
		 * 该创建方法创建线程池会根据实际的业务压力
		 * 去创建和协调线程池中的线程数
		 */
		ExecutorService threadPool = Executors.newCachedThreadPool();//可变的线程池  线程池中的线程长时间没有使用会被销毁
		/**
		 * 提交给线程池并执行业务
		 */
		threadPool.execute(new Runnable() {
			@Override
			public void run() {//匿名内部类
				for (int i = 0; i < 10; i++) {
					System.out.println("为你我受冷风吹");
				}
			}
		});
		threadPool.shutdown();
	}

}
