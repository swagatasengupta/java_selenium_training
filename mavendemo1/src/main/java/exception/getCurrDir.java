package exception;

import java.io.IOException;

public class getCurrDir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String current = "";
		try {
			current = new java.io.File(".").getCanonicalPath();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Method1 - Current dir:" + current);
		
		//alternative way
		String currentDir = System.getProperty("user.dir");
		System.out.println("Method2 - Current dir using System:" + currentDir);
		
		//other important system properties:
		System.out.println("java.home: "+ System.getProperty("java.home"));
		System.out.println("java.version: "+ System.getProperty("java.version"));
		System.out.println("java.class.path: "+ System.getProperty("java.class.path"));
		System.out.println("file.separator: "+ System.getProperty("file.separator"));
		System.out.println("path.separator: "+ System.getProperty("path.separator"));
		System.out.println("os.name: " + System.getProperty("os.name"));
		System.out.println("os.version: " + System.getProperty("os.version"));
		System.out.println("user.home: " + System.getProperty("user.home"));
		System.out.println("user.name: " + System.getProperty("user.name"));

	}

}
