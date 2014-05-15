package kisa;
import java.awt.*;

public class Talas extends Thread implements Prikaziv{
	
	private Bara bara;
	private int x,y;
	private double dr,db,r=0;
	private float crvena=0, zelena=0, plava=0;
	
	public Talas(Bara b,int xx, int yy,
	    double ddr, double ddb){
	    	bara = b; x=xx; y=yy;
	    	dr=ddr; db=ddb;
	    	start();
	}
	
	public void run(){
		try{
		while(!interrupted()){
			sleep(40);
			crtaj();
			r+=dr;
			if(crvena+db<1) crvena += db; else crvena = 1;
			if(zelena+db<1) zelena += db; else zelena = 1;
			if(plava+db<1) plava += db; else plava = 1;
		}
		}catch(InterruptedException g){}
	}
	
	public void crtaj(){
		Graphics g = bara.getGraphics();
		int rr = (int)r;
		g.setColor(new Color(crvena,zelena,plava));
		g.drawOval(x-rr/2,y-rr/2,rr,rr);
	}
	
	public boolean zivTalas(){
		if ((crvena==1) && (zelena==1) && (plava==1)) return false;
		return true;
	}
	
	public void prekini() { interrupt(); }

}
