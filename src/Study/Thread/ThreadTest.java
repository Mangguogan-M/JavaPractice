package Study.Thread;
/**
 * �߳�
 * @author ����
 *�ö��������Բ���ִ��
 * ���� �����ǰ����̵߳�
 * �����߳�
 * �Ǵ������ڴ��е�
 * �ȴ�cpuȥִ�е��̵߳Ľ��� 
 * ʵ���߳�
 * �Ǽ�����cpu�ϵ� ��ͬһʱ��ڵ��Ͽ���ͬʱִ�е��߳���
 * main����������������¿���һ���߳�  ���߳�ȥִ���ڲ�����
 */
public class ThreadTest {
	//�����߳�ִ��main����
	public static void main(String[] args) {

		Thread thread = new Thread() {//��Ҫ���������ڲ������ʽ��д(����)main����
			@Override
			public void run() {/*��������ͬ������������ͬ
				���෵������С�ڵ��ڸ��෽���������ͣ�
				�����׳��쳣С�ڵ��ڸ��෽���׳��쳣��
				�������Ȩ�޴��ڵ��ڸ��෽������Ȩ��*/
				for (int i = 0; i < 12; i++) {
					System.out.println("����Ͱ�ҹ�����ý���");
				}
			}
		};
		
		//�����߳�ȥִ��main����
		thread.start();
		
		ThreadDemo td = new ThreadDemo();
		td.start();//�̳�thread����
		
		RunnableDemo rd = new RunnableDemo();
		Thread td0 = new Thread(rd);
		td0.start();
 		
		
		
		for (int i = 0; i < 10; i++) {
			System.out.println("������֣�ֻ�����ѹ���");
		}
	}
}


/*
 * ʹ���������̳�thread���࣬����дmain����
 */
class ThreadDemo extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("�籩��");
		}
		
	}
}

//����ʵ��runnable�ӿڵķ�ʽ����дrun����
class RunnableDemo implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 12; i++) {
			System.out.println("ʮ��������ʮ��");
		}
		
	}
}