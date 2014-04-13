// Stoperica.java - Klasa casovnika.

package usluge;
import  java.util.Calendar;

public class Casovnik extends Thread {

  private boolean radi = false; // Da li nit treba da radi?
  private Polje datum, vreme;   // Polja za prikaz datuma i vremena.

  public Casovnik(Polje d, Polje v)          // Inicijalizacija.
    { vreme = v; datum = d; start(); }

  public void run() {                        // TELO NITI:
    try {
      while (!interrupted()) {               // - uslovni završetak niti,
        if (!radi) synchronized (this)       // - uslovno pauziranje niti,
          { while (!radi) wait(); }
        Calendar t = Calendar.getInstance(); // - koristan rad,
        if (vreme != null) vreme.pisi(
          t.get(Calendar.HOUR_OF_DAY) + ":" +
          t.get(Calendar.MINUTE)      + ":" +
          t.get(Calendar.SECOND)
        );
        if (datum != null) datum.pisi(
          t.get(Calendar.DATE)     + "." +
         (t.get(Calendar.MONTH)+1) + "." +
          t.get(Calendar.YEAR)
        );
        sleep(1000);                         // - cekanje 1000 ms.
      }
    } catch (InterruptedException g) {}
  }

  public void stani() { radi = false; }      // Privremeno zaustavljanje.

  public synchronized void kreni()           // Nastavak rada.
    { radi = true; notify(); }

  public void zavrsi() { interrupt(); }      // Zavrsetak rada.

}