package victor.training.concurrency;

public class MonitorBasic {
	private static int populatie;
	private static Object monitor = new Object(); 

	public static class ThreadA extends Thread {
		@Override
		public void run() {
			for (int i=0;i<10000;i++) {
				synchronized (monitor) { // SOLUTION
					// critical code
					populatie ++;
				} // SOLUTION
			}
		}
	}
	
	public static class ThreadB extends Thread {
		@Override
		public void run() {
			for (int i=0;i<10000;i++) {
				synchronized (monitor) { // SOLUTION
					// critical code
					populatie ++;
				} // SOLUTION
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		threadA.start();
		threadB.start();
		
		threadA.join();
		threadB.join();
		System.out.println(populatie);
	}
}
