package saobracaj;
import java.awt.*;

public abstract class Akter extends Thread {

	protected boolean radi = false;
	protected Label labela;
	
	public Akter(Label l){ labela = l; start(); }
	public abstract void radnja() throws InterruptedException;
	public void run(){
		try{
		while (!interrupted()){
			if (!radi) synchronized (this) {
				while(!radi) wait();
			}
			System.out.println("Sacu da krenem da radim");
			radnja();
			((Label)labela).setText(this.toString());
			labela.getParent().getParent().validate();
		}
		}catch(InterruptedException g){}
	}
	public void stani() { radi = false; }
	public synchronized void kreni(){
		radi = true; notifyAll();
	}
	public void zavrsi(){ interrupt(); }
	
}
