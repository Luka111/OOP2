package saobracaj;

public class Automobil {
	
	private static int posId = 0;
	private int id = ++posId;
	private double kapacitet,trenutno;
	
	public Automobil(double k){
		kapacitet = k;
		trenutno = (0.1 + Math.random()*0.2)*k;
	}
	public int getId() { return id; }
	public double getKap() { return kapacitet; }
	public double getTren() { return trenutno; }
	synchronized public Automobil sipaj(double kolicina) throws GPuno{
		if (trenutno+kolicina > kapacitet){
			trenutno = kapacitet;
			throw new GPuno();
		}
		trenutno += kolicina;
		return this;
	}
	public String toString() { return id+"("+trenutno+"/"+kapacitet+")"; }
	
}
