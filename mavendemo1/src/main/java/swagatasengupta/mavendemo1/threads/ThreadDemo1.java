package swagatasengupta.mavendemo1.threads;

public class ThreadDemo1 implements Runnable{

	public ThreadDemo1() {
		Thread t = new Thread(this);
		t.start();
	}
	
	public ThreadDemo1(String name) {
		Thread t = new Thread(this, name);
		t.start();
	}
	
	@Override
	public void run() {
		for (int i=1; i<= 10; i++) {
			System.out.println("Thread name: " + Thread.currentThread().getName() + 
					"; Thread id: " + Thread.currentThread().getId() + "; Value of i = " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		Thread t1 = new Thread(new ThreadDemo(), "Custom Thread name 1");
		t1.start();
		
		Thread t2 = new Thread(new ThreadDemo(), "Custom Thread name 2");
		t2.start();
		*/
		
		ThreadDemo1 td1 = new ThreadDemo1();
		ThreadDemo1 td2 = new ThreadDemo1("Custom Name 1");

	}

}
