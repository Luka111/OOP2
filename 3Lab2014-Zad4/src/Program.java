import kisa.*;
import java.awt.*;
import java.awt.event.*;

public class Program extends Frame {
	
	private Bara bara = new Bara();
	private Oblak oblak;
	
	public void popuniProzor(){
		bara.setBackground(Color.WHITE);
		add(bara,"Center");
		oblak = new Oblak(200,500,bara);
		Panel ploca = new Panel();
		Button dugme = new Button("Kreni");
		ploca.add(dugme);
		dugme.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent d){
				oblak.pokreni();
			}
		});
		ploca.add(dugme = new Button("Stani"));
		dugme.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent d){
				oblak.zaustavi();
			}
		});
		add(ploca,"South");
	}
	
	public Program(){
		super("Pljusak");
		setBounds(200,200,800,500);
		setVisible(true);
		popuniProzor();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent d){
				bara.zavrsi();
				oblak.prekini();
				dispose();
			}
		});
	}
	
	public static void main(String[] argv){
		new Program();
	}
	
}
