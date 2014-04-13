package skladista;

public class Izvestac extends Thread{
	
	private static int posId = 0;
	private int id = ++posId;
	private Skladiste sklad;
	private int period;
	
	public Izvestac(Skladiste skl, int per) {sklad = skl; period = per;}
	
	public Izvestac(Skladiste skl) {this(skl,5000);}
	
	public void run(){
		System.out.println("Izvestac : " + id + " krenuo");
		try{
			while(!interrupted()){
				sleep((long)(period));
				System.out.println("Izvestac : " + id + sklad);
			}
		} catch (InterruptedException g) {}
		System.out.println("Izvestac : " + id + " zavrsio");
	}
}
