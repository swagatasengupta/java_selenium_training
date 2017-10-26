package swagatasengupta.mavendemo1.threads;

public class Method3Demo {

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			//@Override
			public void run() {
				for (int i=1;i<=10;i++) {
					System.out.println("Thread: " + Thread.currentThread().getId() + " ("+ Thread.currentThread().getName() + "): count = " + i);
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
				
			}
			
		},"First Thread");
		t1.start();

	}

}
