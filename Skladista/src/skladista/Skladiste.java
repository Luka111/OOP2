package skladista;

public class Skladiste {
	
	private static int posId = 0;
	private int id = ++ posId;
	private int [] niz;
	private int ulaz,izlaz,pun;
	
	public Skladiste(int kap){ niz = new int[kap]; }
	
	public synchronized void stavi(int br) throws InterruptedException{
		while (pun==niz.length) wait();
		niz[ulaz++] = br;
		if (ulaz==niz.length) ulaz = 0;
		pun++;
		notifyAll();
	}
	
	public synchronized int uzmi() throws InterruptedException{
		while (pun == 0) wait();
		int vrati = niz[izlaz++];
		if (izlaz == niz.length) izlaz = 0;
		pun--;
		notifyAll();
		return vrati;
	}
	
	public synchronized String toString(){
		String vrati = id + ":" + "[";
		for (int i=0; i<pun; i++){
			vrati += niz[(izlaz+i) % niz.length];
			if(i<pun-1) vrati+=",";
		}
		vrati+="]";
		return vrati;
	}
}
