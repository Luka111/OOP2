package kisa;
import java.awt.*;

abstract public class Povrs extends Canvas {
	
	public int getSirina() { return this.getWidth(); }
	
	public int getVisina() { return this.getHeight(); }
	
	abstract public void padKapi(Kap k);
	
}
