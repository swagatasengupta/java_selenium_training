package swagatasengupta.mavendemo1.threads;

class Printer2 implements Runnable{
		
	@Override
	public void run(){
		for (int i=1;i<=10;i++) {
			System.out.println("Thread: " + Thread.currentThread().getId() + " ("+ Thread.currentThread().getName() + "): counter = " + i);
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


public class Method2Demo {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Printer2(),"First Thread");
		t1.start();
		Thread t2 = new Thread(new Printer2(),"Second Thread");
		t2.start();
	}
}
