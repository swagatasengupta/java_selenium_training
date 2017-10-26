package Inheritence;

public class Human implements Emotions,Movements{

	String name;
	Human(){
		this.name = "Hu-Man";
	}
	Human(String name){
		this.name = name;
	}
	
	public void displayFear() {
		System.out.println(this.name + " Human is displaying fear");
	}
	public void displayLove() {
		System.out.println(this.name + " Human is displaying Love");
	}
	public void displayHatred() {
		System.out.println(this.name + " Human is displaying Hatred");
	}
	
	public void moveLeft() {
		System.out.println(this.name + " Human is moving Left");
	}
	public void moveRight() {
		System.out.println(this.name + " Human is moving Right");
	}
	public void moveForward() {
		System.out.println(this.name + " Human is moving Forward");
	}
	public void moveBackward() {
		System.out.println(this.name + " Human is moving Backward");
	}

}
