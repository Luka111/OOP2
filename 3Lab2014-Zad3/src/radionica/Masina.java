package radionica;

public class Masina extends Mehanizam {

	private Skladiste skl;
	private Proizvod trenutniProizvod;
	
	public Masina(Skladiste s){ skl = s; }
	
	@Override
	public void radnja() throws InterruptedException{
		skl.dodaj(trenutniProizvod = new Proizvod());
	}
	
	public String toString() { return "M " + trenutniProizvod; }

}
