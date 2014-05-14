package saobracaj;
import java.awt.*;

public class Stanica extends Akter {

	private String ime;
	private long minT, maxT;
	private int brPut = 0;
	
	public Stanica(String i, long min, long max, Label l){
		super(l);
		ime = i; minT = min; maxT = max;
	}
	
	public void radnja() throws InterruptedException{
		// TODO Auto-generated method stub
		System.out.println("CEKAM DA DODJE PUTNIK");
		sleep((long)(minT + Math.random()*(maxT-minT)));
		brPut++;
		System.out.println("......DOCEKAO" + brPut);
	}

	public String getIme(){ return ime; }
	public int getBrPut(){ return brPut; }
	public void smanjiBrPut(){ brPut--; }
	public synchronized String toString(){ return ime + ":" + brPut;}

}
