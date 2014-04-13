// GKompNeOdgovara.java - Klasa za greske: Tip komponente graficke
//                        korisnicke povrsi ne odgovara.

package usluge;
import  java.awt.*;

public class GKompNeOdgovara extends Greska {
  public GKompNeOdgovara(Component k) {
    super("Tip komponente " + k.getClass().getName() +
          " ne odgovara za polje ulaza/izlaza");
  }
}