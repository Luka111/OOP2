package banka;

public class Salter extends Thread {
	private static int min = 3000;
	private static int max = 5000;
	private int id;
	private class Elem{
		Stranka stranka;
		Elem sled;
		Elem (Stranka s){
			stranka = s;
			sled = null;
			if(prvi==null){
				prvi = this;
			}else{
				posl.sled = this;
			}
			posl = this;
		}
	}
	private Elem prvi,posl;
	private int brStranaka = 0;
	private Banka banka;
	
	public Salter(Banka b, int idd){ banka = b; id = idd; start(); }
	
	public void run(){
		System.out.println("Salter krenuo");
		try{
			while(!interrupted()){
				synchronized (this) {
					if(brStranaka == 0) {
						System.out.println("Nema stranaka. Salter je blokiran do daljnjeg!");
						wait();
					}
				}
				Stranka trenutna = izbaci();
				boolean prihvacena = true;
				if (trenutna.getIznos() > banka.novac()) {
					prihvacena = false;
				}else{
					banka.transakcija(trenutna.getIznos());
				}
				sleep((long)(min + Math.random()*(max-min)));
				System.out.println("Broj saltera: " + id + "\n");
				if (prihvacena == false){
					System.out.println("Stranka je odbijena");
				}else{
					System.out.println("Stranka je prihvacena\nIznos novca:" + trenutna.getIznos());
				}
				banka.izlazak();
			}
		}catch(InterruptedException g){}
		System.out.println("Salter zavrsen");
	}
	
	public synchronized int brStranaka(){ return brStranaka; }
	
	public synchronized void stavi(Stranka s){
		new Elem(s);
		brStranaka++;
		notifyAll();
	}
	
	public synchronized Stranka izbaci(){
		if(prvi == null) { return null; }
		Stranka vrati = prvi.stranka;
		prvi = prvi.sled;
		if(prvi == null) posl = null;
		brStranaka--;
		return vrati;
	}
}
