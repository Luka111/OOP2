package baloni;

import java.awt.*;

public class Luk extends Figura{
	
	private int x,y;//koordinate
	private int stranica,korak;
	Color boja;
	Color bojaStrele;
	int duzinaStrele;
	double brzinaStrele;
	
	public Luk(Scena s, int xx, int yy, int str,
	    int kor, Color b, Color bojaS,
	    int duzinaS, double brzinaS){
		super(s);
		x=xx; y=yy; stranica=str; korak=kor;
		boja=b; bojaStrele = bojaS;
		duzinaStrele = duzinaS; brzinaStrele = brzinaS;
	}
	
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
	public int getDuzina() {
		return stranica;
	}

	public void pomerajGore(){
		if (y-korak>=0){
			y -= korak;
		}
	}
	
	public void pomerajDole(){
		int vis = scena.getHeight();
		if (y+korak<=vis){
			y += korak;
		}
	}
	
	@Override
	public void crtaj() {
		Graphics g = scena.getGraphics();
		g.setColor(boja);
		g.drawLine(x,y-stranica/2,x,y+stranica/2);
		g.drawLine(x,y-stranica/2,x+stranica,y);
		g.drawLine(x,y+stranica/2,x+stranica,y);
	}
	
	public void ispaliStrelu(){
	    scena.dodaj(
	    new Strela(scena,x,y,duzinaStrele,brzinaStrele,bojaStrele)
	    );
	}

}
