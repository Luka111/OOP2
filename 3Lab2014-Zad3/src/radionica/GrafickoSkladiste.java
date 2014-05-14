package radionica;
import java.awt.*;

public class GrafickoSkladiste extends Skladiste {

	private TextArea polje;
	private Component parent;
	
	public GrafickoSkladiste(int n, TextArea p){
		super(n); polje = p;
		parent = polje;
		while (parent.getParent() != null) parent = parent.getParent();
	}
	
	public synchronized void dodaj(Proizvod p) throws InterruptedException{
		super.dodaj(p);
		polje.setText(this.toString());
		parent.validate();
	}
	
	public synchronized Proizvod uzmi() throws InterruptedException{
		Proizvod vrati = super.uzmi();
		polje.setText(this.toString());
		parent.validate();
		return vrati;
	}
	
}
