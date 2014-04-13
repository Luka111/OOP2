// Uporediv.java - Interfejs uporedivih objekata.

package usluge;

public interface Uporediv {

  boolean ispred(Uporediv u);   // Da li je ispred drugog objekta?

  boolean jednak(Uporediv u);   // Da li je jednak drugom objektu?
}