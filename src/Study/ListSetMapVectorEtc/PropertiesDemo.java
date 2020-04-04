package Study.ListSetMapVectorEtc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesDemo {
	public static void main(String[] args) throws IOException {
		Properties props = new Properties();
		//加载配置文件
		props.load(PropertiesDemo.class.getResourceAsStream("Config.properties"));
		//读取配置
		String value = props.getProperty("user");
		System.out.println(value);
		//写入内容
		props.setProperty("name", "Monkey·D·Luffy");
		FileOutputStream outStream = new FileOutputStream("bin/Chapter14/Config.properties");
		props.store(outStream, "comments注释的意思");
		
		props.load(PropertiesDemo.class.getResourceAsStream("Config.properties"));
		System.out.println("遍历所有的键值对：");
		for(Entry<Object, Object> entry : props.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
		
	}
}
