package skladiste;

public class Jedinica {
	
	private String oznaka;
	private static String[] oznake = {"kom","l","m","kg"};
	
	public Jedinica(String o) throws GNePostoji{
		boolean postoji = false;
		for(int i=0; i<oznake.length; i++){
			if(o == oznake[i]) postoji = true;
		}
		if (postoji == false) throw new GNePostoji();
		oznaka = o;
	}
	public String getOznaka(){ return oznaka; }
	public String toString() { return oznaka; }
	
}
