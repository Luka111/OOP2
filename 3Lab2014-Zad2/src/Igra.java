import baloni.*;
import java.awt.*;
import java.awt.event.*;

public class Igra extends Frame{

	private Scena scena = new Scena();
	private Luk luk;
	
	public void popuniProzor(){
		add(scena,"Center");
		scena.setBackground(Color.WHITE);
		scena.dodaj(
		    luk = new Luk(scena,5,20,10,10,
		    Color.BLUE,Color.BLACK,16,0.2)
		);
		Panel plo = new Panel();
		add(plo, "South");
		plo.setBackground(Color.GRAY);
		Button dgm = new Button("gore");
		plo.add(dgm);
		dgm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d){
				luk.pomerajGore();
			}
		});
		plo.add(dgm = new Button("dole"));
		dgm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d){
				luk.pomerajDole();
			}
		});
		plo.add(dgm = new Button("pali"));
		dgm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d){
				luk.ispaliStrelu();
			}
		});
		plo.add(dgm = new Button("baloni"));
		dgm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d){
				int sir = scena.getWidth();
				int vis = scena.getHeight();
				for(int i=0; i<5; i++){
					scena.dodaj(
						new Balon(scena,(sir-i*30)-8,
						vis-8,16,Color.GREEN,
						0.06+Math.random()*0.02,Color.RED)
					);
					System.out.println("Dodao sam balon " + i);
				}
			}
		});
	}
	
	public Igra(){
		super("Gadjanje balona");
		setSize(400,300);
		popuniProzor();
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent d){
				scena.zavrsi();
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		new Igra();
	}

}
