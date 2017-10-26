package Inheritence_Family;

public class Mother {
	String name;
	int iq;
	double hairLength;
	private String face;
	String shapeOfFace;
	String complexion;

	Mother(){
		name = "Mom";
		iq = 100;
		hairLength = 2.0;
		face = "Mom's face";
		shapeOfFace = "Oval";
		complexion = "Wheatish";
	}

	Mother(String name, int iq, double hairLength, String face, String shapeOfFace, String complexion){
		this.name = name;
		this.iq = iq;
		this.hairLength = hairLength;
		this.face = face;
		this.shapeOfFace = shapeOfFace;
		this.complexion = complexion;
	}
	
	void displayMothersProperties()
	{
		System.out.println(name + " has IQ " + iq + ", hairlength = " + hairLength + ", face: "+ face + ", Shape of face: " + shapeOfFace + " and complexion: " + complexion);
	}
	
	void canDance() {
		System.out.println(this.name + " can dance");		
	}
	void canDance(String danceStyle) {
		System.out.println(this.name + " can dance: " + danceStyle);
	}
	void canCook(String cookingStyle) {
		System.out.println(this.name + " can cook " + cookingStyle);
	}
}
