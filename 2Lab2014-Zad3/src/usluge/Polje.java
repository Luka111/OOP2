// Polje.java - Polje graficke korisnicke povrsi za unos i prikaz podataka.

package usluge;
import  java.awt.*;

public class Polje {

  private Component komp;             // Pridruzena graficka komponenta.
  private int ind;                    // Indeks stavke u komponenti.
  private Component prozor;           // Roditeljski prozor.

  public Polje(Component k, int i)   // Inicijalizacija.
    throws GKompNeOdgovara {
    if (!(k instanceof Label)         &&
        !(k instanceof TextComponent) &&
        !(k instanceof List)
       ) throw new GKompNeOdgovara(k);
    komp = k; ind = i;
    prozor = komp.getParent();
    while (prozor.getParent() != null) prozor = prozor.getParent();
  }

  public Polje(Component k)
    throws GKompNeOdgovara { this(k, -1); }

  public Component komponenta() // Dohvatanje sadrzane komponente.
    { return komp; }

  public int indeks()           // Dohvatanje indeksa pridruzene stavke.
    { return ind; }

                                     // PRIKAZIVANJE PODATAKA:
  public void pisi(String tekst) {   // - String,
    if      (komp instanceof Label)
      ((Label)komp).setText(tekst);
    else if (komp instanceof TextComponent)
      ((TextComponent)komp).setText(tekst);
    else if (komp instanceof List)
      ((List)komp).replaceItem(tekst, ind);
    prozor.validate();
  }

  public void pisi(long broj)        // - long,
    { pisi(Long.toString(broj)); }
  public void pisi(long broj, int baza)
    { pisi(Long.toString(broj, baza)); }

  public void pisi(double broj)      // - double,
    { pisi(Double.toString(broj)); }

  public void pisi(boolean b)        // - boolean,
    { pisi(Boolean.toString(b)); }

  public void pisi(char znak)        // - char,
    { pisi(Character.toString(znak)); }

  public void pisi(Object o)         // - Object.
    { pisi(o.toString()); }

                                     // UZIMANJE PODATAKA:
  public String String() {           // - String,
    if      (komp instanceof Label)
      return ((Label)komp).getText();
    else if (komp instanceof TextComponent)
      return ((TextComponent)komp).getText();
    else if (komp instanceof List)
      return ((List)komp).getItem(ind);
    else return null;
  }

  public long Long()                 // - long,
    { return Long.parseLong(String()); }

  public long Long(int baza)
    { return Long.parseLong(String(), baza); }

  public int Int()                   // - int,
    { return Integer.parseInt(String()); }

  public int Int(int baza)
    { return Integer.parseInt(String(), baza); }

  public short Short()               // - short,
    { return Short.parseShort(String()); }

  public short Short(int baza)
    { return Short.parseShort(String(), baza); }

  public byte Byte()                 // - byte,
    { return Byte.parseByte(String()); }

  public byte Byte(int baza)
    { return Byte.parseByte(String(), baza); }

  public double Double()             // - double,
    { return Double.parseDouble(String()); }

  public float Float()               // - float,
    { return Float.parseFloat(String()); }

  public boolean Boolean()           // - booelan,
    { return Boolean.parseBoolean(String()); }

  public char Char()                 // - char.
    { return String().charAt(0); }
}