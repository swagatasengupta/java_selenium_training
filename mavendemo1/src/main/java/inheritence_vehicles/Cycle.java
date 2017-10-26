package inheritence_vehicles;

public class Cycle extends Vehicle implements CycleFunctionalities {

	@Override
	public void movePedals() {
		System.out.println("Cycle pedals moved");
	}

	@Override
	public void applyBreak() {
		System.out.println("Cycle breaks applied");
	}

	@Override
	public void releaseBreak() {
		System.out.println("Cycle breaks released");
	}

	@Override
	public void reverseVehicle() {
		System.out.println("Cycle -> Overridden method: Cannot reverse");
	}
	
}
