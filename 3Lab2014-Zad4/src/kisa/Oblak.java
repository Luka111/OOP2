package kisa;

public class Oblak extends Thread {
	
	private long minT, maxT;
	private Povrs povrs;
	private boolean radi=false;
	
	public Oblak(long min, long max, Povrs p){
		minT=min; maxT=max; povrs=p;
		start();
	}
	
	public void run(){
		try{
		while(!interrupted()){
			synchronized (this){ while(!radi) wait(); }
			sleep((long)(minT + Math.random()*(maxT-minT)));
			povrs.padKapi(
			new Kap((int)(
				Math.random()*povrs.getSirina()),
				(int)(Math.random()*povrs.getVisina()),
				2+Math.random()*6
				)
			);
		}
		}catch(InterruptedException g){}
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
	}
	
}
