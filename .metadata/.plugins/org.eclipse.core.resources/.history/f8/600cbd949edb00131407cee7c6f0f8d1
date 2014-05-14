import radionica.*;

import java.awt.*;
import java.awt.event.*;

public class Radionica extends Frame {
	
	private GrafickoSkladiste skl;
	private GrafickiMotor[] mot = new GrafickiMotor[5];
	
	public void popuniProzor(){
		TextArea textPolje = new TextArea();
		skl = new GrafickoSkladiste(20, textPolje);
		Panel ploca = new Panel(new GridLayout(5,1));
		Panel[] nizPloca = new Panel[5];
		for(int i=0; i<5; i++){
			nizPloca[i] = new Panel();
			if(i<3)
				mot[i] = new GrafickiMotor(new Masina(skl), nizPloca[i]);
			else
				mot[i] = new GrafickiMotor(new Traka(skl),nizPloca[i]);
			ploca.add(nizPloca[i]);
		}
		Panel glPloca = new Panel(new GridLayout(1, 2));
		glPloca.add(ploca);
		glPloca.add(textPolje);
		glPloca.validate();
		add(glPloca,"Center");
	}
	
	public Radionica(){
		super("Radionica");
		setBounds(100,100,500,300);
		setVisible(true);
		popuniProzor();
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent d){
				for(int i=0; i<mot.length; i++){
					mot[i].prekini();
				}
				dispose();
			}
		});
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Radionica();
	}

}
