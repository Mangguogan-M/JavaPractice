package Study.Thread;
/**
 * 线程
 * @author 马坤
 *让多个程序可以并行执行
 * 进程 进程是包含线程的
 * 虚拟线程
 * 是存在于内存中的
 * 等待cpu去执行的线程的进程 
 * 实现线程
 * 是集成在cpu上的 是同一时间节点上可以同时执行的线程数
 * main方法是在虚拟机上新开的一个线程  有线程去执行内部代码
 */
public class ThreadTest {
	//开启线程执行main方法
	public static void main(String[] args) {

		Thread thread = new Thread() {//需要采用匿名内部类的形式重写(覆盖)main方法
			@Override
			public void run() {/*方法名相同，参数类型相同
				子类返回类型小于等于父类方法返回类型，
				子类抛出异常小于等于父类方法抛出异常，
				子类访问权限大于等于父类方法访问权限*/
				for (int i = 0; i < 12; i++) {
					System.out.println("想你和熬夜，都该戒了");
				}
			}
		};
		
		//开启线程去执行main方法
		thread.start();
		
		ThreadDemo td = new ThreadDemo();
		td.start();//继承thread父类
		
		RunnableDemo rd = new RunnableDemo();
		Thread td0 = new Thread(rd);
		td0.start();
 		
		
		
		for (int i = 0; i < 10; i++) {
			System.out.println("你的名字，只会是难过！");
		}
	}
}


/*
 * 使用子类来继承thread的类，来重写main方法
 */
class ThreadDemo extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("风暴舞");
		}
		
	}
}

//采用实现runnable接口的方式，重写run方法
class RunnableDemo implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 12; i++) {
			System.out.println("十年三月三十日");
		}
		
	}
}