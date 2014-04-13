// Greska.java - Osnovna klasa za greske.

package usluge;

public class Greska extends Exception {

  private String por;                          // Tekst poruke.
                                               // Inicijalizacija:
  public Greska() {}                           // - bez poruke,
  public Greska(String p) { por = p; }         // - s porukom.

  public String toString()                     // Tekstualni opis.
    { return "*** " + (por != null ? por : "GRESKA"); }

  protected boolean imaPoruke()                // Ima li poruke?
    { return por != null; }
}