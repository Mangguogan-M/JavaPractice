/**  
* <p>Title: DeadLock.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Apr 8, 2019  
* @version 1.0  
*/ 
package Java_ShiLi;

/**  
* <p>Title: DeadLock</p>  
* <p>Description: </p>  
* @author ����  
* @date Apr 8, 2019  
*/
public class DeadLock implements Runnable{
	private boolean flag;
	private static final Object o1 = new Object();
	private static final Object o2 = new Object();
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ":flag=" + flag);
		if (flag == true) {
			synchronized (o1) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(threadName + "����ͬ����o1׼������o2");
				synchronized (o2) {
					System.out.println(threadName+ "�Ѿ�����ͬ����o2");
				}
			}
		}
		if (flag == false) {
			synchronized (o2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(threadName + "����ͬ����o2׼������o1");
				synchronized (o1) {
					System.out.println(threadName + "�Ѿ�����ͬ����o1");
				}
			}
		}
	}
	public static void main(String[] args) {
		DeadLock d1 = new DeadLock();
		DeadLock d2 = new DeadLock();
		d1.flag = true;
		d2.flag = false;
		new Thread(d1).start();
		new Thread(d2).start();
	}
}
