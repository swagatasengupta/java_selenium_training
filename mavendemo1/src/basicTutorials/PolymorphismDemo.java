package basicTutorials;

public class PolymorphismDemo {

	double volume;
	
	PolymorphismDemo() {
		System.out.println("Constructor of PolymorphismDemo is called.");
		volume = 0.1;
	}
	PolymorphismDemo(double volume){
		this.volume = volume;
		System.out.println("Constructor of PolymorphismDemo is called. Inital volume set as: " + volume);
		
	}
	
	void calculateVolume() {
		System.out.println("Error: No arguments passed on to calculate volume");
		//return -1.0;
	}
	
	double calculateVolume(double length) {
		// assume volume calculation is for a cube
		volume = length * length * length;
		return volume;
	}
	
	double calculateVolume(double length, double breadth, double height) {
		volume = length * breadth * height;
		return volume;
	}
	
	void displayVolume() {
		System.out.println("Calculated Volume is: " + volume);
	};
	
	
	public static void main(String[] args) {
		// Create instance1 of PolymorphismDemo using default constructor
		// default constructor will set the volume as 0.1
		PolymorphismDemo testPolyMorphism1 = new PolymorphismDemo();
		//call calculateVolume function of the instance1 and store return value in vol1
		//this function definition should result in error as no dimension is passed.
		//System.out.println(testPolyMorphism1.calculateVolume());
		testPolyMorphism1.calculateVolume();
		//Now again call calculateVolume with only one argument (dimension).
		// expect volume of cube to be returned and stored in vol1
		double vol1 = testPolyMorphism1.calculateVolume(3.0);
		//Display whatever is stored in volume attribute of instance1
		testPolyMorphism1.displayVolume();
		//call calculateVolume using function definition that supports 3 arguments.
		vol1 = testPolyMorphism1.calculateVolume(3.0, 5.0, 6.0);
		//Print value of vol1
		System.out.println("Vol1 = " + vol1);
		
		//Create another instance2 of PolymorphismDemo with constructor passing on an
		//initial volume
		PolymorphismDemo testPolyMorphism2 = new PolymorphismDemo(5.0);
		//call calculateVolume for instance2 with one argument
		testPolyMorphism2.calculateVolume(4.0);
		// call displayVolume for instance2
		testPolyMorphism2.displayVolume();
		// call displayVolume for instance1 to show that volumes of both instances are
		// different
		testPolyMorphism1.displayVolume();
	}

}
