package baloni;
import java.awt.*;
import java.awt.event.*;

public class Scena extends Canvas implements Runnable {
	
	private Thread nit = new Thread(this);
	private Elem prvi,posl;
	private class Elem{
		Figura fig;
		Elem sled;
		Elem(Figura f){
			fig=f;
			if (prvi==null) prvi = this; else posl.sled = this;
			posl = this;
		}
	}
	
	public Scena(){ nit.start(); }
	public synchronized void dodaj(Figura fig){
		new Elem(fig);
	}
	public synchronized void izbaci(Figura fig){
		Elem tek = prvi, pret = null;
		while (tek!=null && tek.fig != fig){
			pret = tek; tek = tek.sled;
		}
		if(tek != null){
			if (pret == null) prvi = tek.sled; else pret.sled = tek.sled;
			if (tek.sled == null) posl = pret;
		}
	}
	public synchronized Figura dovhati(){
		if (prvi==null) return null;
		Figura fig = prvi.fig;
		izbaci(prvi.fig);
		return fig;
	}
	public synchronized void paint(Graphics g){
		for (Elem tek=prvi; tek!=null; tek=tek.sled) tek.fig.crtaj();
	}
	
	public void run(){
		try{
			while (!Thread.interrupted()) { repaint(); Thread.sleep(40); }
		}catch(InterruptedException g){}
	}
	
	public boolean proveriBusenje(int xBalona, int yBalona, int rBalona){
		for(Elem tek=prvi; tek!=null; tek=tek.sled){
			if(tek.fig instanceof Strela){
				if((tek.fig.getX() + tek.fig.getDuzina() >= xBalona)
				&& (tek.fig.getX() + tek.fig.getDuzina() <= xBalona + rBalona)
				&& (tek.fig.getY() >= yBalona - rBalona/2) 
				&& (tek.fig.getY() <= yBalona + rBalona/2)){
					return true;
				}
			}
		}
		return false;
	}
	
	public void zavrsi() { nit.interrupt(); }
}
