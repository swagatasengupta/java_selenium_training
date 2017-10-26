package swagatasengupta.mavendemo1.threads;

public class ThreadDemo3 {

	public static int count;
	
	public static synchronized void incCount() {
		count++;
	}
	
	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable(){

			//@Override
			public void run() {
				for (int i=1; i<= 1000; i++) {
					incCount();
/*					System.out.println("Thread name: " + Thread.currentThread().getName() + 
							"; Thread id: " + Thread.currentThread().getId() + "; Value of i = " + i);
*/					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		}
		); // Thread constructor ends
		t1.start();
		Thread t2 = new Thread(new Runnable(){

			//@Override
			public void run() {
				for (int i=1000; i>= 1; i--) {
					if(i%2==0) {
						incCount();
/*						System.out.println("Thread name: " + Thread.currentThread().getName() + 
								"; Thread id: " + Thread.currentThread().getId() + "; Even i = " + i);*/
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
				
			}
			
		}
		); // Thread constructor ends
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Main ends: Value of count is " + count);
	}

}
