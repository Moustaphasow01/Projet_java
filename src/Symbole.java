package src;

public class Symbole {
    private int id;
    private int[] gains;

    public Symbole(int id, int[] gains) {
        this.id = id;
        this.gains = gains;
    }

    public int getId() {
        return id;
    }

    public int getGain(int combinaison) {
        return gains[combinaison - 3];
    }
}
