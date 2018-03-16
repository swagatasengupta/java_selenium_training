package Inheritence_Family;

public class Son extends Mother {

	String name; //any re-definition of attributes will override the inherited attribute.
	double height;
	
	Son(String name, double height){
		this.name = name;
		this.height = height;
	}
	Son(String name, double height, String motherName, int iq, double hairLength, String face, String shapeOfFace, String complexion){
		super(motherName, iq, hairLength, face, shapeOfFace, complexion);
		this.name = name;
		this.height = height;		
	}
	
	void canPlayCricket() {
		System.out.println(this.name + " can play cricket");
	}
	void canDrive() {
		System.out.println(this.name + " can drive");
	}

	void displaySonProperties() {
		System.out.println(this.name + ", has height " + this.height);
	}
	
	@Override
	void canDance(String danceStyle) {
		System.out.println(this.name + "can dance " + danceStyle + " very well");
	}
	public static void main(String[] args) {
		Son jay = new Son("Jay",6.0);
		jay.displaySonProperties();
		jay.displayMothersProperties();
		
		Son veeru = new Son("Veeru", 5.10, "Verru's mom", 110, 2.5, "Like Jayalalitha", "Round", "White");
		veeru.displaySonProperties();
		veeru.displayMothersProperties();
		veeru.canCook("Indian");
		veeru.canDrive();
		veeru.canDance("Hip Hop");
	}
	
}
