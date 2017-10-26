package basicTutorials;

public class ThisDemo {

	public static void main(String[] args) {
		Student s1 = new Student(111,"ankit",5000f);  
		Student s2 = new Student(112,"sumit",6000f);  
		s1.displayAllAttribs();  
		s2.displayAllAttribs(); 
		Student s3 = new Student(); 

	}
	void displayRollNo() {// notice a function with similar name is also there in Student class.
		System.out.println("Roll Number");
	}
	void displayName() {
		System.out.println("Namer");
	}
	void displayFee() {
		System.out.println("Fee");
	}

}

class Student{  
	int rollno;  
	String name;  
	float fee;  

	Student(){// default constructor - Note no public or private is mentioned. But java default constructor is public.
					// if no private or public is mentioned, an attribute or method is visible to all the classes in the package. 
		rollno=1;
		name="Defaut Name";
		fee = 0.0f;
		System.out.println("Default Values being assigned by default constructor: " + rollno+" "+name+" "+fee);
	}
	
	Student(int rollno,String name,float fee){  
			this(); // calls default constructor first always. Then proceeds with the remaining actions.
		//			rollno=rollno;  
		//			name=name;  
		//			fee=fee; 
		// since the name of the arguments and class attributes are same, Java will assign the argument to itself and the class attributes will not get initialized.
		// hence, this is required as mentioned blow:
			this.rollno=rollno;  
			this.name=name;  
			this.fee=fee; 
			System.out.println("Overridden default Values with assigned values: " + rollno+" "+name+" "+fee);
	}  
	void displayAllAttribs(){
		System.out.println("displayAllAttribs(): " + rollno+" "+name+" "+fee);
		this.displayRollNo(); // Use of this to call functions internal to a class.
		this.displayName(); // Use of this to call functions internal to a class.
		this.displayFee(); // Use of this to call functions internal to a class.
		}  
	void displayRollNo() {
		System.out.println("displayRollNo(): " + rollno);
	}
	void displayName() {
		System.out.println("displayName(): " + name);
	}
	void displayFee() {
		System.out.println("displayFee(): " + fee);
	}

}  