package Java_ShiLi.Text143;

public class TempThread implements Runnable {// �����õ�Runnable�ӿ�ʵ����
    private int id = 0;
    
    @Override
    public void run() {// run()������id����������
        id++;
    }
}