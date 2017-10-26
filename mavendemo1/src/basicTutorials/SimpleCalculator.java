package basicTutorials;

public class SimpleCalculator {
	double result;
	SimpleCalculator(){
		result = 0.0;
	}
	
	double Addition(double num1, double num2) {
		return result = num1 + num2;
	}
	
	
	double Multiplication(double num1, double num2) {
		return result = num1 * num2;
	}
	
	double Division(double num1, double num2) {
		return result = num1 / num2;
	}
	
	double Subtraction(double num1, double num2) {
		return result = num1 - num2;
	}

	public static void main(String[] args) {
		
		String invalidInputErrorMsg = "Input should be in the format: \"Add <num1> <num2>\", OR \"Subtract <num1> <num2>\", OR \"Multiply <num1> <num2>\", OR \"Divide <num1> <num2>\".";
		SimpleCalculator calc = new SimpleCalculator(); 
		if(args.length !=3) {
			if (args.length == 1  && args[0].trim().compareToIgnoreCase("BREAK")==0) {
				System.out.println("Exiting program");
			} else {
				
				System.out.println("Invalid number of arguments.");
				System.out.println(invalidInputErrorMsg);
			}
		} else {
			switch(args[0].trim().toUpperCase()){
				case "ADD": System.out.println("Result: " + calc.Addition(Double.parseDouble(args[1]), Double.parseDouble(args[2])));
							break;
			
				case "SUBTRACT": System.out.println("Result: " + calc.Subtraction(Double.parseDouble(args[1]), Double.parseDouble(args[2])));
							break;
				
				case "MULTIPLY": System.out.println("Result: " + calc.Multiplication(Double.parseDouble(args[1]), Double.parseDouble(args[2])));
							break;
				
				case "DIVIDE": 
							if(Double.parseDouble(args[2])==0.0){
								System.out.println("Error: Cannot divide by 0");
								break;
							}
							System.out.println("Result: " + calc.Division(Double.parseDouble(args[1]), Double.parseDouble(args[2])));
							break;
				default: System.out.println("Error: Unrecognized command: " + args[0]);
						System.out.println(invalidInputErrorMsg);
			}
		}
	
	}

}
