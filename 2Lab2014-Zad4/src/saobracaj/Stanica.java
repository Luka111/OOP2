package saobracaj;

public class Stanica {
	
	private Pumpa[] pumpe = new Pumpa[4];
	private Automobil[] red = new Automobil[20];
	private int poz,naPunjenju;
	private boolean radi = false;
	
	public Stanica(){
		for(int i=0; i<pumpe.length; i++){
			pumpe[i] = new Pumpa(this);
		}
	}
	public Stanica otvori(){
		radi = true;
		for(int i=0; i<pumpe.length; i++){
			pumpe[i].otvori();
		}
		return this;
	}
	synchronized public void prekini() throws InterruptedException{
		radi = false;
		System.out.println("------ STANICA ------ : Cekam da svi zavrse punjenje");
		while(naPunjenju!=0) wait();
		System.out.println("------ STANICA ------ : Svi su napunili, gasim pumpe");
		for(int i=0; i<pumpe.length; i++){
			pumpe[i].zatvori();
		}
	}
	synchronized public void stavi(Automobil a){
		if ((poz==pumpe.length-1) || (radi == false)) {
			System.out.println("------ STANICA ------ : Stanica ne radi ili je puna");
			return;
		}
		System.out.println("------ STANICA ------ : Stavljam...");
		red[poz++] = a;
		notifyAll();
		System.out.println("------ STANICA ------ : Broj automobila na stanici: " + poz);
	}
	synchronized public Automobil uzmi () throws InterruptedException{
		System.out.println("Ocu da uzmem!");
		while((poz==0) || (radi==false)){
			if (radi == false) {
				System.out.println("------ STANICA ------ : NE MOZE DA SE UZIMA, STANICA JE ZATVORENA");
			}else{
				System.out.println("------ STANICA ------ : Nisam uspeo da uzmem jer nema nijednog automobila");
			}
			wait();
		}
		System.out.println("------ STANICA ------ : ...Uzeo sam");
		naPunjenju++;
		poz--;
		notifyAll();
		return red[poz];
	}
	synchronized public void dojava(){
		naPunjenju--;
		notifyAll();
	}
	public String toString() {
		String vrati = "";
		for(int i=0; i<pumpe.length; i++) vrati += pumpe[i].toString()+"\n";
		vrati += "[";
		for(int i=0; i<poz; i++){
			if(i>0) vrati+= ",";
			vrati += red[i].toString();
		}
		vrati+="]";
		return vrati;
	}
}
