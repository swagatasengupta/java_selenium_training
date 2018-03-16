package inheritence_vehicles;

public class Vehicle {

	protected int numWheels;
	
	public void turnLeft() {
		System.out.println("Vehicle -> Turning Left");
	}
	
	public void turnRight() {
		System.out.println("Vehicle -> Turning Right");
	}
	public void reverseVehicle() {
		System.out.println("Vehicle -> Reversing");
	}
	public void goStraight() {
		System.out.println("Vehicle -> Moving forward");
	}
	
}
