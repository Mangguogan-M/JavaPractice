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
* <p>Description: �̳߳�</p>  
* �����ڴ��б�����Ӧ�������߳���
* ���ڴ���ҵ�񣬴������֮�󲻻�����
* �����ڴ��о�����ڵȴ�֮���ҵ��
* @author ����  
* @date Mar 30, 2019  
*/
public class ThreadPool {
	public static void main(String[] args) {
		/**
		 * �����̳߳�
		 * �ô������������̳߳ػ����ʵ�ʵ�ҵ��ѹ��
		 * ȥ������Э���̳߳��е��߳���
		 */
		ExecutorService threadPool = Executors.newCachedThreadPool();//�ɱ���̳߳�  �̳߳��е��̳߳�ʱ��û��ʹ�ûᱻ����
		/**
		 * �ύ���̳߳ز�ִ��ҵ��
		 */
		threadPool.execute(new Runnable() {
			@Override
			public void run() {//�����ڲ���
				for (int i = 0; i < 10; i++) {
					System.out.println("Ϊ��������紵");
				}
			}
		});
		threadPool.shutdown();
	}

}
