package test;

import java.util.ArrayList;
import java.util.Random;

public class Rouleau {
    private ArrayList<Symbole> symboles;
    private int taille;

    public Rouleau(int taille) {
        this.taille = taille;
        symboles = new ArrayList<>(taille);
    }

    public void genererSymboles() {
        String[] symbolesPossibles = {"A", "B", "C", "D", "E", "F", "G", "H", "Super", "Free", "Bonus"};
        Random random = new Random();

        for (int i = 0; i < taille; i++) {
            symboles.add(new Symbole(symbolesPossibles[random.nextInt(symbolesPossibles.length)]));
        }
    }

    public ArrayList<Symbole> getSymboles() {
        return symboles;
    }
}
