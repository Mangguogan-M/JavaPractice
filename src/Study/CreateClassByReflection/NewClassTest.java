package Study.CreateClassByReflection;

import java.io.File;
import java.lang.reflect.Constructor;

public class NewClassTest {
    
    public static void main(String[] args) {
        try {
            Constructor<File> constructor = File.class.getDeclaredConstructor(String.class);
            System.out.println("ʹ�÷��䴴��File����");
            File file = constructor.newInstance("d://����.txt");
            System.out.println("ʹ��File������D�̴����ļ�������.txt");
            file.createNewFile();
            System.out.println("�ļ��Ƿ񴴽��ɹ���" + file.exists());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
