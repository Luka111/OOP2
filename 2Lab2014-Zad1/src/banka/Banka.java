package banka;

public class Banka {
	private Ulaz ulaz;
	private Salter salter1, salter2;
	private double novac;
	private int brStranaka = 0;
	
	public Banka(){ulaz = new Ulaz(this); salter1 = new Salter(this,1); salter2 = new Salter(this,2); }
	public void otvori(double n){
		novac = n;
		System.out.println("Pocetna suma: " + novac);
		ulaz.otvori();
	}
	public void zatvori(){
		ulaz.zatvori();
		System.out.println("ULAZ ZATVOREN - NEMA VISE ULAZAKA");
		try{
			synchronized (this) {
				while (brStranaka>0) {
					System.out.println("CEKAM SVE STRANKE DA ZAVRSE, OSTALO JOS " + brStranaka + " STRANAKA");
					wait();
				}
			}
		}catch (InterruptedException g){}
		System.out.println("Preostala suma: " + novac);
		ulaz.interrupt();
		salter1.interrupt();
		salter2.interrupt();
	}
	public double novac(){ return novac; }
	public int getBrStranaka(){ return brStranaka; }
	public void transakcija(double iznos){ novac+=iznos; }
	public void ulazak(Stranka s){
		Salter biraj;
		if (salter1.brStranaka() >= salter2.brStranaka()){
			biraj = salter1;
		}else{
			biraj = salter2;
		}
		biraj.stavi(s);
		brStranaka++;
	}
	synchronized public void izlazak(){
		brStranaka--;
		notifyAll();
	}
}
