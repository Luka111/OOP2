package radionica;

public class Traka extends Mehanizam {

	private Skladiste skl;
	private Proizvod trenutniProizvod;
	
	public Traka(Skladiste s){ skl = s; }
	
	@Override
	public void radnja() throws InterruptedException{
		trenutniProizvod = skl.uzmi();
	}
	
	public String toString(){
		return "T " + trenutniProizvod;
	}

}
