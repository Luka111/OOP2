package skladista;

public class Program {

	public static void main(String[] args) {
		Skladiste skl = new Skladiste(30);
		Thread [] niti = new Thread[11];
		for(int i=0; i<7; i++){
			niti[i] = new Proizvodjac(skl);
		}
		for(int i=0; i<3; i++){
			niti[i] = new Potrosac(skl);
		}
		niti[10] = new Izvestac(skl);
		for (int i=0; i<11; i++){
			niti[i].start();
		}
		try{
			Thread.sleep(15000);
		} catch (InterruptedException g){}
		for(int i=0; i<11; i++){
			niti[i].interrupt();
		}
		System.out.println("Glavna zavrsila");
	}

}
