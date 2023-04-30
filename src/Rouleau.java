package src;

import java.util.ArrayList;
import java.util.Collections;

public class Rouleau {
    private ArrayList<Symbole> symboles;

    public Rouleau(ArrayList<Symbole> symboles) {
        this.symboles = symboles;
        Collections.shuffle(this.symboles);
    }

    public Symbole getSymbole(int index) {
        return symboles.get(index);
    }
}
