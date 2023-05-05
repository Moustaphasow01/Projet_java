package test;

import java.util.ArrayList;
import java.util.Random;

public class Colonne {
    private Rouleau rouleau;
    ArrayList<Symbole> affichage;

    public Colonne(Rouleau rouleau) {
        this.rouleau = rouleau;
        affichage = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            affichage.add(null);
        }
    }

    public void tourner() {
        Random random = new Random();
        int indexDebut = random.nextInt(rouleau.getSymboles().size());

        for (int i = 0; i < 5; i++) {
            int index = (indexDebut + i) % rouleau.getSymboles().size();
            affichage.set(i, rouleau.getSymboles().get(index));
        }
    }

    public void afficher() {
        for (Symbole symbole : affichage) {
            System.out.print(symbole + " ");
        }
        
        System.out.print(" | ");
    }
    
    public boolean estGagnante() {
        Symbole symbolePrecedent = null;
        int compteurSymbole = 1;
        for (Symbole symbole : affichage) {
            if (symbolePrecedent != null && symbole.equals(symbolePrecedent)) {
                compteurSymbole++;
                if (compteurSymbole == 3) {
                    return true;
                }
            } else {
                symbolePrecedent = symbole;
                compteurSymbole = 1;
            }
        }
        return false;
    }
}
