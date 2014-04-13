package skladiste;

public class Skladiste {
	
	private String naziv;
	private String adresa;
	private Niz niz;
	
	public Skladiste (String n, String a) throws GVelicina { naziv = n; adresa = a; niz = new Niz(5); }
	public Skladiste dodaj(Zapis z) throws GJednaki,GIndex{
		for(int i=0; i<niz.brElem(); i++){
			if(z.getArtikal().jednaki(niz.dohvati(i).getArtikal())) throw new GJednaki();
		}
		niz.dodaj(z);
		return this;
	}
	public Zapis dohvatiZapis(String nazivArtikla) throws GNema,GIndex{
		for(int i=0; i<niz.brElem(); i++){
			if (niz.dohvati(i).getArtikal().getNaziv() == nazivArtikla) return niz.dohvati(i);
		}
		return null;
	}
	public double ukVrednost() throws GIndex{
		double vrati=0;
		for(int i=0; i<niz.brElem(); i++){
			vrati+= niz.dohvati(i).vrednost();
		}
		return vrati;
	}
	public String toString(){
		return niz.toString();
	}
	
}
