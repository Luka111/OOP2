import banka.*;
public class program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Glavni krenuo");
		Banka b = new Banka();
		b.otvori(5000);
		try{
			Thread.sleep(20000);
		}catch (InterruptedException g){}
		b.zatvori();
		System.out.println("Glavni zavrsio");
	}

}
