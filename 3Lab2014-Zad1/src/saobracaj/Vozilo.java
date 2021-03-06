package saobracaj;
import java.awt.*;

public class Vozilo extends Akter {
	
	private String oznaka;
	private int kap, brPut = 0;
	private long minT, maxT, zadrzavanje;
	private int trStanica = 0; //trenutna stanica
	private int smer = 1; //smer kretanja
	private Stanica[] stanice; 
	
	public Vozilo(String o, int k, long min, 
	    long max, long z, Stanica[] s, Label l){
		super(l); 
		oznaka = o; kap = k; minT = min; 
		maxT = max; zadrzavanje = z; stanice = s;
	}
	
	
	
	@Override
	public void radnja() throws InterruptedException{
		// TODO Auto-generated method stub
		//cekanje da stigne do stanice
		sleep((long)(minT + Math.random()*(maxT-minT)));
		//izlazak putnika
		brPut -= (int)(brPut*Math.random());
		//cekanje da putnici udju u autobus
		sleep((long)zadrzavanje);
		//ulazak putnika u autobus
		if (stanice[trStanica].getBrPut() < kap - brPut){
			brPut += stanice[trStanica].getBrPut();
		}else{
			brPut = kap;
		}
		//promena sledece stanice
		if(trStanica == stanice.length - 1){
			smer = -1;
		}
		if (trStanica == 0){
			smer = 1;
		}
		trStanica += smer;
	}
	
	public synchronized String toString() {
		return oznaka +  " vozi ka " + stanice[trStanica] + ":" + brPut;
	}

}
