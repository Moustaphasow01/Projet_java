package test;

import java.util.ArrayList;
import java.util.Random;

public class Bonus {
    private enum Case {
        GAIN, FULL, EMPTY
    }

    private int[][] gains;
    private Case[][] cases;

    public Bonus() {
        gains = new int[4][5];
        cases = new Case[4][5];
        initMatrice();
    }

    private void initMatrice() {
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                int mise = 2000; // Remplacez cette valeur par la mise actuelle du joueur
                switch (i) {
                    case 0:
                        gains[i][j] = rand.nextInt((int) (mise * 2 - mise / 2) + 1) + (int) (mise / 2);
                        cases[i][j] = Case.GAIN;
                        break;
                    case 1:
                        gains[i][j] = rand.nextInt((int) (mise * 5 - mise * 2) + 1) + (int) (mise * 2);
                        cases[i][j] = Case.GAIN;
                        break;
                    case 2:
                        gains[i][j] = rand.nextInt((int) (mise * 8 - mise * 5) + 1) + (int) (mise * 5);
                        cases[i][j] = Case.GAIN;
                        break;
                    case 3:
                        gains[i][j] = rand.nextInt((int) (mise * 16 - mise * 10) + 1) + (int) (mise * 10);
                        cases[i][j] = Case.GAIN;
                        break;
                }
            }
        }
        cases[0][4] = Case.FULL;
        cases[1][3] = Case.EMPTY;
        cases[1][4] = Case.FULL;
        cases[2][2] = Case.EMPTY;
        cases[2][4] = Case.FULL;
        cases[3][2] = Case.EMPTY;
        cases[3][4] = Case.FULL;
    }

    public int jouerBonus(int ligne, int colonne) {
        int gain = 0;
        if (cases[ligne][colonne] == Case.GAIN) {
            gain = gains[ligne][colonne];
        } else if (cases[ligne][colonne] == Case.FULL) {
            for (int i = 0; i < 5; i++) {
                gain += gains[ligne][i];
            }
        }
        return gain;
    }

    public boolean isPartieBonusFinie(int ligne, int colonne) {
        return cases[ligne][colonne] == Case.EMPTY;
    }

    
}