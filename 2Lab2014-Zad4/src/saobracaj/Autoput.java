package saobracaj;

public class Autoput extends Thread {
	
	private Stanica stanica;
	
	public Autoput(Stanica s){ stanica = s; start(); System.out.println("Autoput pokrenut!"); }
	public Stanica getStanica() { return stanica; }
	public void prekini() {
		try{
			stanica.prekini(); interrupt();
		}catch(InterruptedException g){}
	}
	public void run(){
		try{
			while (!interrupted()){
				sleep((long)(500 + Math.random()*500));
				stanica.stavi(new Automobil(50));
				System.out.println("------ AUTOPUT ------: Stavio sam automobil!");
			}
		}catch(InterruptedException g){}
	}
	
}
