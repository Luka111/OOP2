package skladiste;

public class Artikal {
	
	private String naziv;
	private Jedinica jedinica;
	
	public Artikal(String n, Jedinica j) { naziv = n; jedinica = j; }
	public String getNaziv() { return naziv; }
	public Jedinica getJedinica() { return jedinica; }
	public boolean jednaki(Artikal a) { return naziv == a.naziv; }
	public String toString() { return naziv; }
}
