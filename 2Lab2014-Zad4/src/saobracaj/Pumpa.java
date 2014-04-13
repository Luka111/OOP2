package saobracaj;

public class Pumpa extends Thread {
	
	private Stanica stanica;
	private Automobil automobil;
	
	public Pumpa (Stanica s) { stanica = s; }
	public void run() {
		try{
			while(!interrupted()){
				automobil = stanica.uzmi();
				while(automobil.getTren()<automobil.getKap()){
					sleep(100);
					try{
						automobil.sipaj(1);
					}catch(GPuno g){ System.out.println(g); }
				}
				stanica.dojava();
			}
		}catch (InterruptedException g){}
	}
	public void otvori() { start();System.out.println("------ PUMPA ------ : Pumpa pokrenuta!"); }
	public void zatvori() { interrupt();System.out.println("------ PUMPA ------ : Pumpa prekinuta!"); }
	synchronized public String toString() { if(automobil != null) return automobil.toString(); else return "------ PUMPA ------ : Nema automobila na cekanju";}
}
