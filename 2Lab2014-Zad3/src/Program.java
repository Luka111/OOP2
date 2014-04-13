import radnik.*;
import usluge.*;
public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Radnik radnik = null;
		radi: while (true){
			try{
				System.out.print("1. Napravi radnika\n"+
								 "2. Zahtevaj od radnika da napravi predmet\n" +
								 "3. Ispitaj da li radnik ima gotov proizvod\n" +
								 "4. Preuzmi proizvod od radnika i ispisi proizvod\n" +
								 "5. Ispisi radnika na glavnom izlazu\n" +
								 "0. Zavrsi program\n");
				switch (Citaj.Int()) {
					case 1: radnik = new Radnik("Mile",10); break;
					case 2: if (radnik != null) {
						radnik.zahtev(50);
					} else {
						System.out.println("NEMA RADNIKA!");
					}
					break;
					case 3: if (radnik != null) {
						if (radnik.zaPreuzimanje()) {
							System.out.println("Ima!");
						} else {
							System.out.println("Nema!");
						}
					}
					break;
					case 4: if (radnik != null){
						System.out.println("Ocu da preuzmem!");
						/*if (radnik.zaPreuzimanje() == false){
							System.out.println("Nema proizvoda za preuzimanje, trazite za zahtev kasnije...");
							continue radi;
						}*/
						Proizvod p = radnik.preuzmi();
						System.out.println("Proizvod: " + p);
					}
					break;
					case 5: if (radnik != null){
						System.out.println("Radnik: " + radnik);
					}
					break;
					case 0: radnik.zaustavi(); break radi;
					default: continue radi;
				}
			}catch (InterruptedException g){}
		}
	}

}
