package test;

import java.util.ArrayList;
import java.util.Random;

public class Colonne {
    private Rouleau rouleau;
    private ArrayList<Symbole> affichage;
    private Symbole symbole;

    public Colonne(Rouleau rouleau) {
        this.rouleau = rouleau;
        affichage = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            affichage.add(new Symbole(""));
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
            System.out.print(symbole.getValeur() + " ");
        }
        System.out.println();
    }
    
    public Symbole getSymbole() {
        return symbole;
    }
}

