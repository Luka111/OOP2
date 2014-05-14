package baloni;

public abstract class Figura {
	
	protected Scena scena;
	
	protected Figura(Scena s){
		(scena = s).dodaj(this);
	}
	public abstract int getX();
	public abstract int getY();
	public abstract int getDuzina();
	//iscrtavanje figure
	public abstract void crtaj();
	
}
