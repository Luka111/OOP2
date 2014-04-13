package banka;

public class Stranka {
	
	private static double min=-1000;
	private static double max=1000;
	private double iznos = 0;
	
	public Stranka(){ iznos = min + Math.random()*(max-min); }
	public double getIznos() { return iznos; }
}
