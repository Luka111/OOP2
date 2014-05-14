package radionica;

public class Skladiste {
	
	private Proizvod[] proizvodi;
	private int ulaz,izlaz;
	private int pun;
	
	public Skladiste(int n){ proizvodi = new Proizvod[n]; }
	
	public synchronized void dodaj(Proizvod p) throws InterruptedException{
		while (pun==proizvodi.length) wait();
		proizvodi[ulaz++] = p;
		if (ulaz==proizvodi.length) ulaz = 0;
		pun++;
		notifyAll();
	}
	
	public synchronized Proizvod uzmi() throws InterruptedException{
		while (pun==0) wait();
		Proizvod vrati = proizvodi[izlaz++];
		if (izlaz==proizvodi.length) izlaz = 0;
		pun--;
		notifyAll();
		return vrati;
	}
	
	public synchronized String toString(){
		String vrati="";
		for (int i=0; i<pun; i++){
			vrati += proizvodi[(i+izlaz) % proizvodi.length].toString() + "\n";
		}
		return vrati;
	}
	
}
