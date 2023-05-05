package test;

import java.util.ArrayList;
import java.util.Random;

public class Rouleau {
  private ArrayList < Symbole > symboles;
  private int taille;

  public Rouleau(int taille) {
    this.taille = taille;
    symboles = new ArrayList < > (taille);
  }

  public void genererSymboles() {
    Symbole[] symbolesPossibles = {
      Symbole.COEUR,
      Symbole.PIQUE,
      Symbole.CARRE,
      Symbole.TREFLE,
      Symbole.CERISE,
      Symbole.CITRON,
      Symbole.ORANGE,
      Symbole.CLOCHE,
      Symbole.SUPER,
      Symbole.FREE,
      Symbole.BONUS
    };

    Random random = new Random();

    for (int i = 0; i < taille; i++) {
      symboles.add(symbolesPossibles[random.nextInt(symbolesPossibles.length)]);
    }
  }

  public ArrayList < Symbole > getSymboles() {
    return symboles;
  }

  public String getSymbole(int i) {
    return symboles.get(i).name();
  }

}
