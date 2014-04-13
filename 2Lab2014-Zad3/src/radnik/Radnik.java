package radnik;

public class Radnik extends Thread {
	
	private String ime;
	private int produktivnost; //produktivnost izrazena kao g/s
	private boolean zauzet = false; //da li je radnik zauzet (da li proizvodi ili se ceka preuzimanje)
	private Proizvod proizvod; 
	private boolean proizvedeno = false; // da li postoji proizvod na koji se ceka preuzimanje
	
	public Radnik(String i,int prod){ ime = i; produktivnost = prod; start(); System.out.println("Radnik zapoceo!");}
	public void run(){
		try{
			while(!interrupted()){
				synchronized (this) {
					while((zauzet==false) || (proizvedeno == true)) {
						System.out.println("Radnik je zauzet!!!");
						wait();
					}
				}
				int masa = 0;
				while(masa<proizvod.getMasa()){
					sleep(1000);
					masa+= produktivnost;
					System.out.println("Napravio : " + masa + "/" + proizvod.getMasa());
				}
				System.out.println("Napravio sam ceo proizvod!");
				proizvedeno=true;
				System.out.println("Proizvedeno = true!");
				synchronized (this) {
					notifyAll();
				} 
			}
		}catch(InterruptedException g){}
	}
	synchronized public void zahtev(int m) throws InterruptedException{
		while (zauzet == true) {
			System.out.println("Ne mogu da dam zahtev jer je radnik zauzet!");
			wait();
		}
		proizvod = new Proizvod(m);
		zauzet = true;
		notifyAll();
	}
	synchronized public Proizvod preuzmi() throws InterruptedException{
		while (proizvedeno == false) {
			System.out.println("Ne mogu da preuzmem jer proizvod nije gotov!");
			wait();
		}
		zauzet = false;
		notifyAll();
		Proizvod p = proizvod;
		proizvod = null;
		return p;
	}
	synchronized public boolean zaPreuzimanje(){ return proizvedeno; }
	synchronized public String toString() {
		String vrati = ime+"/";
		if (zauzet == false){
			vrati += "ceka";
		}else{
			if(proizvedeno==false){
				vrati += "radi";
			}else{
				vrati += proizvod.toString();
			}
		}
		return vrati;
	}
	synchronized public void zaustavi(){
		interrupt();
	}
}
