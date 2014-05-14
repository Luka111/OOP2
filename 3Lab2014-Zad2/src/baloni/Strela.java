package baloni;
import java.awt.*;

public class Strela extends Figura {
	
	private int x,y;//koordinate
	private int duzina;
	private double brzina;
	Color boja;
	
	public Strela(Scena s, int xx, int yy, int duz, double brz, Color b){ super(s); x=xx; y=yy; duzina=duz; brzina=brz; boja=b; }
	
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
	public int getDuzina(){
		return duzina;
	}
	
	public void crtaj(){
		int sir = scena.getWidth();
		int vis = scena.getHeight();
		if (x>=0 && x<sir && y>=0 && y<vis){
			Graphics g = scena.getGraphics();
			g.setColor(boja);
			g.drawLine(x,y,x+duzina,y);
			x += brzina*40;
		}else{
			scena.izbaci(this);
		}
	}

}
