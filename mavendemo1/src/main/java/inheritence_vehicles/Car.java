package inheritence_vehicles;

public class Car extends Vehicle implements CarFuntionalities {

	@Override
	public void openDoor() {
		System.out.println("Car door opened");
	}

	@Override
	public void closeDoor() {
		System.out.println("Car door closed");

	}

	@Override
	public void startWiper() {
		System.out.println("Car wiper started");
	}

	@Override
	public void stopWiper() {
		System.out.println("Car wiper stopped");

	}

	@Override
	public void startEngine() {
		System.out.println("Car engine started");
	}

	@Override
	public void stopEngine() {
		System.out.println("Car engine stopped");
	}

	@Override
	public void turnLeft() {
		System.out.println("Car is turning with left indicator on.");
	}
	
	@Override
	public void turnRight() {
		System.out.println("Car is turning with right indicator on.");
	}
}
