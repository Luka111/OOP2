package radionica;

public class Motor extends Thread {
	
	protected int dt = 100;
	protected Mehanizam mehanizam;
	private boolean radi = false;
	
	public Motor(Mehanizam m){ mehanizam = m; start(); }
	
	public void promeniVreme(int ndt){ dt = ndt; }
	
	public void run(){
		try{
			while(!interrupted()){
				System.out.println("Sibam ko lud");
				synchronized (this) {
					while (!radi) wait();
				}
				sleep((long)(dt*(0.8 + Math.random()*0.4)));
				radnja();
			}
		}catch(InterruptedException g){System.out.println("Mrs napolje");}
	}
	
	protected void radnja() throws InterruptedException {
		mehanizam.radnja();
	}
	
	public synchronized void pokreni(){
		radi = true;
		notifyAll();
	}
	
	public void zaustavi(){
		radi = false;
	}
	
	public void prekini(){
		interrupt();
		System.out.println("Ugasio sam je");
	}
	
	public String getMehanizamString() { return mehanizam.toString(); }
	
}
