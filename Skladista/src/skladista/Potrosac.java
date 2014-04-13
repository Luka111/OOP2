package skladista;

public class Potrosac extends Thread{
	
	private static int posId = 0;
	private int id = ++ posId;
	private Skladiste sklad;
	private int min,max;
	
	public Potrosac(Skladiste skl, int minn, int maxx){
		sklad = skl; min = minn; max = maxx;
	}
	
	public Potrosac(Skladiste skl){
		this(skl,1000,2000);
	}
	
	public void run(){
		System.out.println("Potrosac : " + id + " krenuo");
		try{
			while(!interrupted()){
				int uzeo = sklad.uzmi();
				System.out.println("Potrosac : " + id + " uzima " + uzeo);
				sleep((long)(min + Math.random() *  (max-min)));
			}
		} catch (InterruptedException g) {}
		System.out.println("Potrosac : " + id + " zavrsio");
	}
}
