package Inheritence;

public class SuperHuman extends Human implements SuperHumanAbilities{
	String fancyName;
	
	SuperHuman(){
		this.fancyName = "X Man";
	}
	SuperHuman(String fancyName){
		this.fancyName = fancyName;
	}
	SuperHuman(String realName, String fancyName){
		super(realName);
		this.fancyName = fancyName;
	}
	
	
	public void canFly() {
		System.out.println(fancyName + " Super Human is Flying");
	}
	public void canLiftHeavyWeights() {
		System.out.println(fancyName + " Super Human is Lifting Heavy Weights");
	}

	public static void main(String[] args) {
		//SuperHuman spiderman = new SuperHuman("Spider Man");
		SuperHuman spiderman = new SuperHuman("Peter Parker", "Spider Man");
		spiderman.canLiftHeavyWeights();
		spiderman.moveLeft();
		spiderman.displayFear();
		
		SuperHuman superman = new SuperHuman("Super Man");
		superman.canFly();
		superman.displayLove();
		superman.canLiftHeavyWeights();
		superman.moveForward();
		
		SuperHuman wolverine = new SuperHuman();
		wolverine.moveBackward();
		wolverine.canLiftHeavyWeights();
		
	}
}
