package kisa;
import java.awt.*;

public class Bara extends Povrs implements Runnable {
	
	private Elem prvi,posl;
	private Thread nit = new Thread(this);
	private class Elem{
		Talas talas;
		Elem sled;
		Elem(Talas t){
			talas = t;
			if(prvi == null) prvi = this; else posl.sled = this;
			posl = this;
		}
	}
	
	public Bara(){ nit.start(); }
	
	public synchronized void padKapi(Kap k){
		new Elem(new Talas(this,k.x,k.y,k.tezina*0.05,0.05/k.tezina));
	}
	
	public synchronized void paint(Graphics g){
		for (Elem tek=prvi; tek!=null; tek=tek.sled){
			if (tek.talas.zivTalas()){
				tek.talas.crtaj();
			}else{
				tek.talas.prekini();
				izbaci(tek.talas);
			}
		}
	}
	
	public synchronized void izbaci(Talas t){
		Elem tek = prvi, pret = null;
		while(tek!=null && tek.talas!=t){
			pret = tek; tek = tek.sled;
		}
		if(tek != null){
			if(pret == null) prvi = tek.sled; 
			    else pret.sled = tek.sled;
			if (tek.sled == null) posl = pret;
			if (prvi == null) posl = null;
		}
	}
	
	@Override
	public void run() {
		try{
			while(!Thread.interrupted()){
				repaint();
				Thread.sleep(40);
			}
		}catch(InterruptedException g){}
	}
	
	public synchronized void zavrsi(){
		for (Elem tek=prvi; tek!=null; tek=tek.sled){
			tek.talas.prekini();
		}
		nit.interrupt();
	}

}
