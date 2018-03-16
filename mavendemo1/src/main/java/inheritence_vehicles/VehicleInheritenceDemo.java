package inheritence_vehicles;

public class VehicleInheritenceDemo {

	public static void main(String[] args) {

		GearedBiCycle gbc = new GearedBiCycle();
		gbc.changeGear(1);
		System.out.println(gbc.getCurrGear());
		gbc.goStraight();
		gbc.movePedals();
		gbc.reverseVehicle();
		gbc.changeGear(2);
		System.out.println(gbc.getCurrGear());
		
		HybridCar hbc = new HybridCar();
		hbc.setFuelType("Diesel");
		hbc.fillFuel(10);
		hbc.displayFuelLevel();
		hbc.chargeCar();
		hbc.displayChargeLevel();
		hbc.startEngine();
		hbc.reverseVehicle();
		
	}

}
