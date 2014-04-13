package banka;

public class Ulaz extends Thread {
	
	private static int min = 1000;
	private static int max = 3000;
	private boolean radi = false;
	private Banka banka;
	
	public Ulaz(Banka b){ banka = b; start(); }
	
	public void run(){
		System.out.println("Ulaz pokrenut");
		try{
			while(!interrupted()){
				synchronized (this) {
					if(!radi) {
						System.out.println("Ulaz je zatvoren. Sacekajte da se otvori!");
						wait();
					}
				}
				sleep((long)(min + Math.random()*(max-min)));
				System.out.println("Stranka ulazi u banku");
				banka.ulazak(new Stranka());
			}
		}catch (InterruptedException g) {}
		System.out.println("Ulaz zavrsen");
	}
	
	public synchronized void otvori(){
		System.out.println("Ulaz otvoren");
		radi = true;
		notifyAll();
	}
	
	public synchronized void zatvori(){
		radi = false;
	}
	
	public synchronized void unisti(){
		interrupt();
	}
	
}
