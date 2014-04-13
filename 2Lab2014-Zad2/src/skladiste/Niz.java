package skladiste;

public class Niz {
	
	private Zapis[] zapisi;
	private int kap;
	private int poz;
	private static class Ispisivac extends Thread{
		private Zapis zapis;
		private String ispis;
		
		public Ispisivac(Zapis z) { zapis = z; start(); }
		public void run() { ispis = zapis.toString() + "\n"; }
		public String getIspis() { return ispis; }
	}
	
	public Niz(int n) throws GVelicina { if(n<=0) throw new GVelicina(); zapisi = new Zapis[n]; kap = n;}
	public void dodaj(Zapis z){
		if (poz == kap-1) {
			int noviKap = kap/10;
			if (noviKap<5) noviKap = 5;
			Zapis[] novi = new Zapis[noviKap];
			for (int i=0; i<poz; i++){
				novi[i] = zapisi[i];
			}
			zapisi = novi;
			kap = noviKap;
		}
		zapisi[poz++] = z;
	}
	public int brElem() { return poz; }
	public Zapis dohvati(int poz) throws GIndex {
		if (poz<0 || poz>=kap) throw new GIndex();
		return zapisi[poz];
	}
	public String toString(){
		String vrati = "";
		Ispisivac[] ispisivaci = new Ispisivac[poz];
		for (int i=0; i<poz; i++){
			ispisivaci[i] = new Ispisivac(zapisi[i]);
		}
		try{
			for(int i=0; i<poz; i++){
				ispisivaci[i].join();
				vrati+=ispisivaci[i].getIspis();
			}
		}catch (InterruptedException g){}
		return vrati;
	}
	
}
