package skladiste;

public class Zapis implements Vrednosno {
	
	private Artikal artikal;
	private int kolicina;
	private double jedCena;
	
	public Zapis(Artikal a, int k, double jc){ artikal = a; kolicina = k; jedCena = jc; }
	public Artikal getArtikal() { return artikal; }
	public int getKolicina() { return kolicina; }
	public double getJedCena() { return jedCena; }
	
	public void setKolicina(int kol) { kolicina = kol; }
	public void setJedCena(double jc) { jedCena = jc; }
	
	@Override
	public double vrednost() {
		// TODO Auto-generated method stub
		return kolicina*jedCena;
	}
	public String toString() { return "Artikal: " + artikal + " Kolicina:" + kolicina + " Jedinica:" + artikal.getJedinica() + " Jed.Cena:" + jedCena + " Vrednost:" + vrednost(); }

}
