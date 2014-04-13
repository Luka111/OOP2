package skladista;

public class Proizvodjac extends Thread{
	
	private static int posId = 0;
	private int id = ++posId;
	private int br;
	private int min,max;
	private Skladiste sklad;
	
	public Proizvodjac(Skladiste skl, int minn, int maxx){
		min = minn; max = maxx; sklad = skl;
	}
	
	public Proizvodjac(Skladiste skl){
		this(skl,1000,2000);
	}
	
	public void run(){
		System.out.println("Proizvodjac : " + id + " krenuo");
		try{
			while(!interrupted()){
				sleep((long)(min + Math.random() *  (max-min)));
				int broj = 1000*id + (++br);
				System.out.println("Proizvodjac : " + id + " stavlja " + broj);
				sklad.stavi(broj);
			}
		} catch (InterruptedException g) {}
		System.out.println("Proizvodjac : " + id + " zavrsio");
	}
}
