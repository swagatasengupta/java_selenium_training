package swagatasengupta.mavendemo1.threads;

public class SynchronizedDemo {

	public static int count;
	
	public static synchronized void incCount() {
		count++;
	}
	
	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			//@Override
			public void run() {
				for (int i=1;i<=1000000;i++) {
					//System.out.println("Thread: " + Thread.currentThread().getId() + " ("+ Thread.currentThread().getName() + "): i = " + i);
					//count++;
					incCount();
				}
			}
			
		},"First Thread");
		t1.start();

		Thread t2 = new Thread(new Runnable() {

			//@Override
			public void run() {
				for (int j=1;j<=1000000;j++) {
					//System.out.println("Thread: " + Thread.currentThread().getId() + " ("+ Thread.currentThread().getName() + "): j = " + j);
					//count++;
					incCount();
				}
			}
			
		},"Second Thread");
		t2.start();
		try {
			//Thread.sleep(1);
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Value of count = " + count);
	}

}
