package inheritence_vehicles;

public class GearedBiCycle extends Cycle implements GearedBiCycleFunctionalities {

	private int gearNum;
	
	@Override
	public void changeGear(int gearNum) {
		this.gearNum = gearNum;
		System.out.println("Geared Bicycle -> Changed gear to: " + this.gearNum);
	}

	public String getCurrGear() {
		return String.valueOf(gearNum);
	}
	
}
