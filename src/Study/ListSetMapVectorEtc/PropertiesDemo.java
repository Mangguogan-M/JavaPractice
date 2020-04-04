package Study.ListSetMapVectorEtc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesDemo {
	public static void main(String[] args) throws IOException {
		Properties props = new Properties();
		//���������ļ�
		props.load(PropertiesDemo.class.getResourceAsStream("Config.properties"));
		//��ȡ����
		String value = props.getProperty("user");
		System.out.println(value);
		//д������
		props.setProperty("name", "Monkey��D��Luffy");
		FileOutputStream outStream = new FileOutputStream("bin/Chapter14/Config.properties");
		props.store(outStream, "commentsע�͵���˼");
		
		props.load(PropertiesDemo.class.getResourceAsStream("Config.properties"));
		System.out.println("�������еļ�ֵ�ԣ�");
		for(Entry<Object, Object> entry : props.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
		
	}
}
