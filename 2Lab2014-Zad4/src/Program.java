import saobracaj.*;
public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stanica stanica = new Stanica();
		Autoput autoput = new Autoput(stanica);
		stanica.otvori();
		int brIspisa = 6;
		try{
			while(brIspisa != 0){
					Thread.sleep(3000);
					System.out.println(stanica);
					brIspisa--;
			}
		}catch (InterruptedException g){}
		/*try{
			Thread.sleep(10000);
		}catch(InterruptedException g){}
		System.out.println(stanica);*/	
		System.out.println("Ispisao sam 6 puta");
		autoput.prekini();
		System.out.println("Zavrsio sam program");
	}

}
