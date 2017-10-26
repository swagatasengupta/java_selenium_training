package basicTutorials;

import java.util.Scanner;

public class PrintPrimeNumUpto {

	public static void main(String[] args) {
		//One of the use of Scanner class from Java.util is to scan console input.
		//It can scan integers, strings etc.
		Scanner scan = new Scanner(System.in);
		String input = null;
		System.out.println("Please enter a number and system will print prime numbers between 1 to that number: ");

		//Here the approach is to use regular expressions to ascertain if an entered number is greater than or equal to 1
		//Until the input is in desired format, the system will keep on prompting the user for re-rentering input.
		input = scan.nextLine().trim();
		while(!input.matches("([2-9][0-9]*|1[0-9]+)")){ //check a single digit or multiple digits
			System.out.println("Invalid input. Please enter a positive number greater than 1");
			input = scan.nextLine().trim();
		}
		scan.close();
		int num = Integer.parseInt(input);

		String primeNumbers = "";
		int countPrimeNums = 0;
		
		for (int i=1; i<=num; i++) {
			if(isPrime(i)) {
				primeNumbers += i + " ";
				countPrimeNums++;
			} 
		}
		System.out.println("There is/are "+ countPrimeNums +" prime numbers between 1 and " + num + " is/are: " + primeNumbers);
		
		
	}

	static boolean isPrime(int num) {
		
		if(num == 1 || num==2) {
			return true;
		}
		for (int i = 2; i<=num/2; i++){
			if(num % i == 0) return false;
		}
		
		return true;
	}
}
