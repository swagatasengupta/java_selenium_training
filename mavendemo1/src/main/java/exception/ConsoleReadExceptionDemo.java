package exception;

import java.util.Scanner;

public class ConsoleReadExceptionDemo {

	public static void getNum() throws Exception {
		System.out.println("Enter a number: ");
		Scanner scan = new Scanner(System.in);
		
		int a = Integer.parseInt(scan.nextLine().trim());
		System.out.println("Entered value is " + a);
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Try block - line 1");
			ConsoleReadExceptionDemo.getNum();
			System.out.println("Try block - line 2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Custom Error Message");
			System.out.println("e.toString()" + e.toString());
			System.out.println("e.getMesage()" + e.getMessage());
			e.printStackTrace();
		}
		finally {
			System.out.println("Final Message");
		}

	}

}
