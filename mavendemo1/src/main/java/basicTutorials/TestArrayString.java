package basicTutorials;

public class TestArrayString {

	public static void main(String[] args) {
		// Create a string array of same length as the number of arguments passed
		// on to main.
		// this is not known beforehand so this needs to be dynamically done.
		
		String[] strTest = new String[args.length];
		
		//Initialize string array iteratively with args 
		for (int i=0; i<args.length; i++) {
			strTest[i]=new String(args[i]);
		}
		
		// Print string array in reverse order
		for (int i=strTest.length-1; i>=0;i--) {
			System.out.println(strTest[i]);
		}
	}

}
