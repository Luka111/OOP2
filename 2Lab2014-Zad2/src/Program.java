import skladiste.*;
public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Skladiste skladiste = new Skladiste("Magacin","Bircaninova 25");
			skladiste.dodaj(
					new Zapis(new Artikal("Keks",new Jedinica("kom")),20,5.25)
			).dodaj(
					new Zapis(new Mleko("Kravica"),30,62.50)
			).dodaj(
					new Zapis(new Secer("Fidelinka"),50,120.00)
			);
			System.out.println("Ukupna vrednost: " + skladiste.ukVrednost() + "\n");
			System.out.println("Zapisi: " + skladiste);
		}catch (Exception g){
			System.out.println(g);
		}
		
	}

}
