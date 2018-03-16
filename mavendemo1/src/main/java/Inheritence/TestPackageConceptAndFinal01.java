package Inheritence;

import inheritence_vehicles.*;
import inheritence_vehicles.subpackage1.subpackage_1_1.*;


public class TestPackageConceptAndFinal01 {

	private final double pi=3.14159;
	private final String path;
	public TestPackageConceptAndFinal01(){
		path = null;
	}
	public TestPackageConceptAndFinal01(String path){
		this.path = path;
	}
	public String getPath() {
		return path;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle v = new Vehicle();
		HybridCar h = new HybridCar();
		Cycle2 c2 = new Cycle2();
		TestPackageConceptAndFinal01 t1 = new TestPackageConceptAndFinal01();
		System.out.println(t1.getPath());

		TestPackageConceptAndFinal01 t2 = new TestPackageConceptAndFinal01("some path\\path");
		System.out.println(t2.getPath());

	}

}
