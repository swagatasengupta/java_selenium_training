package inheritence_vehicles;

public class HybridCar extends Car implements FossilFuelCarFunctionalities, ElectricCarFunctionalities {

	private int chargeLevel;
	private int fossilFuelLevel;
	private String fuelType;
	
	public HybridCar(){
		chargeLevel = 0;
		fossilFuelLevel = 0;
		fuelType = "";
	}
	
	@Override
	public void chargeCar() {
		System.out.println("Hybrid car charging");
		chargeLevel++;
	}

	@Override
	public void displayChargeLevel() {
		System.out.println("Hybrid car -> charge level" + chargeLevel);
	}

	@Override
	public void fillFuel(int fuelVolume) {
		fossilFuelLevel+=fuelVolume;
		System.out.println("Hybrid car --> filled " + fossilFuelLevel + " litres of fossil fuel");
	}

	@Override
	public void displayFuelLevel() {
		System.out.println("Hybrid car -> "+ this.fuelType+ " level= " + fossilFuelLevel);
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	@Override
	public void reverseVehicle() {
		System.out.println("Hybrid car -> Overridden grand parent function - Reversing");
	}
}
