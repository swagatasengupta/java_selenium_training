package basicTutorials;

public class RefDataTypesDemo {

	private String str1;
	private String str2;
	private String str3;
	private String str4;
	
	RefDataTypesDemo(){
		//String Literal - Will be created in string constant pool in heap memory
		str1 = "This is a String";
		//Note - Here "This is a String" is the object and str1 is just a reference.
		//str2 = "This is a String";  // will not create one more object "This is a string", it will just create another reference to the object "This is a String".
		str3 = new String("This is another String");
		//String object - Will be stored in heap where all other objects are stored
		//Note - Here "This is another String" is the object and str1 is just a reference.
		//str4 = "This is another String";  // will create ANOTHER object "This is another String". str4 will be a reference to a NEW object.
		str1 = "This is a modified String";
		//String is a 'immutable' object. Once assigned it cannot be changed.
		// This statement means a new object "This is a modified String" is created and str1 now references it.
		// str1 will lose reference to "This is a String" object. Essentially, "This is a String" object will be orphaned and garbage collector will handle this.
		// -------------- Hence, using String Literal actually ensures better memory utilization --------------------;
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
