package exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileDemo {

	public static void main(String[] args) {
		
		String projPath = System.getProperty("user.dir");
		String relFilePath = "\\src\\exception\\demo.properties";
		//System.out.println(projPath+relFilePath);
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(projPath + relFilePath);
			prop.load(fis);
			System.out.println(prop.getProperty("key1"));
			System.out.println(prop.getProperty("key2"));
			System.out.println(prop.getProperty("key3"));
			System.out.println(prop.getProperty("key_3"));

			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
