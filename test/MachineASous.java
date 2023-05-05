package test;
import java.util.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MachineASous {
  private ArrayList < Rouleau > rouleaux;
  private Joueur joueur;
  private Bonus bonus;
  private Free free;
  private boolean partieBonus;
  private boolean toursGratuits;
  private List < Colonne > colonnes;
  final int NOMBRE_gagnant = 10;

  public MachineASous() {
    rouleaux = new ArrayList < > ();
    joueur = new Joueur(250000);
    bonus = new Bonus();
    free = new Free();

    // Initialiser les rouleaux
    for (int i = 0; i < 1; i++) {
      rouleaux.add(new Rouleau(30));
    }
    rouleaux.add(new Rouleau(41));

    // Générer les symboles pour chaque rouleau
    for (Rouleau rouleau: rouleaux) {
      rouleau.genererSymboles();

    }
    colonnes = new ArrayList < > ();
    //----------------------------------->>>> generation de la machine a sous avec les 5 colonnes 
    for (int j = 0; j <= 4; j++) {
      for (int i = 0; i <= 2; i++) {
        if (j == 4) {
          // Génere la 5eme colonnes de 41 symboles
          Rouleau rouleau = new Rouleau(41);
          rouleau.genererSymboles();

          colonnes.add(new Colonne(rouleau));
        } else {
          // Génere les 4  premieres colonnes de 30 symboles 
          Rouleau rouleau = new Rouleau(30);
          rouleau.genererSymboles();
          colonnes.add(new Colonne(rouleau));
        }

      }
    }

  }

  public Joueur getJoueur() {
    return joueur;
  }

  //--------------------------------------------------------
  public int jouer(int mise, Joueur joueur) {
    // Vérifier si le joueur a suffisamment de fonds pour miser
    if (joueur.getSolde() < mise) {
      System.out.println("Solde insuffisant pour miser !");
      return 0;
    }
    joueur.retirerMise(mise);
    // generer un nombre aleatoire entre 1 et 10 qui corresnspondra au lancer gagnant .
    Random random = new Random();
    int nbgagnant = random.nextInt(10) + 1;

    // ---------- tirage

    // Générer les symboles pour chaque rouleau
    Random rand = new Random();
    Symbole[][] symboles = new Symbole[5][3];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 3; j++) {
        // Vérifier si le rouleau est le numéro 3 et le symbole est super
        if (i == 2 && Symbole.SUPER.equals(symboles[2][j])) {
          symboles[2][j] = Symbole.values()[rand.nextInt(Symbole.values().length - 3)];
        } else {
          // Générer un symbole aléatoire, en donnant 30 fois plus de chance aux symboles non spéciaux
          int rnd = rand.nextInt(100);
          if (rnd < 90) {
            symboles[i][j] = Symbole.values()[rand.nextInt(Symbole.values().length - 3)];
          } else {
            symboles[i][j] = Symbole.values()[Symbole.values().length - rnd % 3 - 1];
          }
        }
      }
    }

    // Afficher les symboles pour chaque rouleau
    System.out.println("Symboles obtenus :");

    // Afficher les symboles de chaque rouleau
    for (int i = 0; i < 3; i++) { // Boucle pour chaque ligne des rouleaux
      for (int j = 0; j < 5; j++) { // Boucle pour chaque rouleau
        System.out.print("+--------+   ");
      }
      System.out.println();
      for (int j = 0; j < 5; j++) { // Boucle pour chaque rouleau
        System.out.print("|        |   ");
      }
      System.out.println();

      for (int j = 0; j < 5; j++) { // Boucle pour chaque rouleau
        System.out.printf("| %-6s |   ", symboles[j][i].toString());
      }
      System.out.println();
      for (int j = 0; j < 5; j++) { // Boucle pour chaque rouleau
        System.out.print("|        |   ");
      }
      System.out.println();
    }

    for (int j = 0; j < 5; j++) { // Boucle pour chaque rouleau
      System.out.print("+--------+   ");
    }
    System.out.println();
    // Vérifier si le joueur a gagné ou perdu
    int gain = 0;
    int count = 0;
    for (int j = 0; j < 3; j++) {
      if (symboles[0][j] == symboles[1][j] && symboles[1][j] == symboles[2][j] && symboles[2][j] == symboles[3][j] && symboles[3][j] == symboles[4][j]) {
        count++;
      }
    }
    if (count > 0) {
      // Le joueur a gagné le jackpot
      gain = mise * 10 * count;
      System.out.println("Jackpot !!! Vous avez gagné " + gain + "$ !");
    } else {
      // Compter le nombre de symboles identiques sur chaque rouleau
      int[] countSymboles = new int[Symbole.values().length];
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 3; j++) {
          countSymboles[symboles[i][j].ordinal()]++;
        }
      }

      // Vérifier si le joueur a gagné une somme d'argent ou perdu
      int nbSymbolesIdentiques = 0;
      int multiplicateurGain = 0;

      for (int i = 0; i < countSymboles.length; i++) {
        if (countSymboles[i] >= 3) {
          switch (i) {
          case 0:
            multiplicateurGain = 5;
            break;
          case 1:
            multiplicateurGain = 4;
            break;
          case 2:
            multiplicateurGain = 3;
            break;
          case 3:
            multiplicateurGain = 6;
            break;
          case 4:
            multiplicateurGain = 5;
            break;
          case 5:
            multiplicateurGain = 5;
            break;
          case 6:
            multiplicateurGain = 5;
            break;
          case 7:
            multiplicateurGain = 5;
            break;
          case 8:
            multiplicateurGain = 5;
            break;
          }

          gain = mise * multiplicateurGain;
          System.out.println("Félicitations, vous avez gagné " + gain + "$ !");
          joueur.ajouterGains(gain);
          return gain;
        } else {
          nbSymbolesIdentiques += countSymboles[i];
        }
      }

      if (nbSymbolesIdentiques < 3) {
        System.out.println("Vous avez perdu " + mise + "$ !");
        joueur.retirerMise(mise);
        return -mise;
      } else {
        System.out.println("Dommage, vous n'avez pas gagné cette fois-ci.");
        return 0;
      }

    }
    // Retourner les gains du joueur
    return gain;
  }

  //--------------------------------------------------------

  /*public int jouer(int mise, Joueur joueur) {
      // Vérifiez si le joueur a suffisamment de fonds pour miser
      if (joueur.getSolde() < mise) {
          System.out.println("Solde insuffisant pour miser !");
          return 0;
      }
      this.joueur.retirerMise(mise);

   // Générer les symboles pour chaque rouleau
      Random rand = new Random();
      Symbole symboleRouleau1 = Symbole.values()[rand.nextInt(Symbole.values().length)];
      Symbole symboleRouleau2 = Symbole.values()[rand.nextInt(Symbole.values().length)];
      Symbole symboleRouleau3 = Symbole.values()[rand.nextInt(Symbole.values().length)];

      // Afficher les symboles pour chaque rouleau
      System.out.println("Symboles obtenus : " + symboleRouleau1 + " " + symboleRouleau2 + " " + symboleRouleau3);

      // Vérifier si le joueur a gagné ou perdu
      int gain = 0;
      if (symboleRouleau1 == symboleRouleau2 && symboleRouleau2 == symboleRouleau3) {
          // Le joueur a gagné le jackpot
          gain = mise * 10;
          System.out.println("Jackpot !!! Vous avez gagné " + gain + "$ !");
      } else if (symboleRouleau1 == symboleRouleau2 || symboleRouleau2 == symboleRouleau3 || symboleRouleau1 == symboleRouleau3) {
          // Le joueur a gagné une somme d'argent
          gain = mise * 2;
          System.out.println("Félicitations, vous avez gagné " + gain + "$ !");
      } else {
          // Le joueur a perdu sa mise
          System.out.println("Dommage, vous avez perdu votre mise !");
      }

      // Ajouter les gains du joueur à son solde
      joueur.ajouterGains(gain);

      // Retourner les gains du joueur
      return gain;
  }*/
  public void afficherResultat() {
    for (Colonne colonne: colonnes) {
      colonne.afficher();
    }
  }
  public boolean estGagnante() {
    // Vérifiez les combinaisons gagnantes pour chaque ligne
    for (int i = 0; i < 3; i++) {
      Symbole symbole = colonnes.get(i).affichage.get(0);
      if (symbole != null && symbole.equals(colonnes.get(i + 1).affichage.get(0)) &&
        symbole.equals(colonnes.get(i + 2).affichage.get(0))) {
        return true;
      }
    }
    return false;
  }

  public boolean isPartieBonus() {
    return partieBonus;
  }

  public boolean isToursGratuits() {
    return toursGratuits;
  }

  public Bonus getBonus() {
    return bonus;
  }

  public Free getFree() {
    return free;
  }
}
