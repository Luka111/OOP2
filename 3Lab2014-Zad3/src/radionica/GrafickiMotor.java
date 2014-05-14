package radionica;
import java.awt.*;
import java.awt.event.*;

public class GrafickiMotor extends Motor {
	
	private Panel ploca;
	private Checkbox polje;
	private TextField textPolje;
	
	public GrafickiMotor(Mehanizam m, Panel p){
		super(m); ploca=p;
		popuniPlocu();
	}
	
	private void popuniPlocu(){
		System.out.println("Popunjavam...");
		polje = new Checkbox("radi");
		RadiPromena osluskivac = new RadiPromena();
		polje.addItemListener(osluskivac);
		ploca.add(polje);
		Label labela = new Label("dt: ");
		ploca.add(labela);
		textPolje = new TextField(Integer.toString(dt));
		VremePromena osluskivacVr = new VremePromena();
		textPolje.addTextListener(osluskivacVr);
		ploca.add(textPolje);
		ploca.add(labela = new Label(mehanizam.toString()));
	}
	
	private class RadiPromena implements ItemListener{
		public void itemStateChanged(ItemEvent d){
			if(polje.getState()){
				pokreni();
			}else{
				zaustavi();
			}
		}
	}
	
	private class VremePromena implements TextListener{
		public void textValueChanged(TextEvent d){
			promeniVreme(Integer.parseInt(textPolje.getText()));
		}
	}
	
}
