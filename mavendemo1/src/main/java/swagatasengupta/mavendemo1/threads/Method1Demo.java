package swagatasengupta.mavendemo1.threads;

class Printer1 extends Thread{
	
	public Printer1(String name){
		super(name);
	}
	
	@Override
	public void run(){
		for (int i=1;i<=10;i++) {
			System.out.println("Thread: " + Thread.currentThread().getId() + " ("+ Thread.currentThread().getName() + "): i = " + i);
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public class Method1Demo {

	public static void main(String[] args) {
		Printer1 prn1 = new Printer1("First Thread");
		prn1.start();
		Printer1 prn2 = new Printer1("Second Thread");
		prn2.start();
	}

}
