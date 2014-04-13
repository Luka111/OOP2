package radnik;

public class Proizvod {
	
	private static int posId = 0;
	private int id = ++posId;
	private int masa; //masa izrazena u gramima
	
	public Proizvod(int m){ masa = m; }
	public int getMasa(){ return masa; }
	public String toString() { return id+"("+masa+")"; }
	
}
