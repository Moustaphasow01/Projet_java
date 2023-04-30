package src;

public class Joueur {
    private int solde;

    public Joueur(int soldeInitial) {
        solde = soldeInitial;
    }

    public void ajouterGains(int gains) {
        solde += gains;
    }

    public void soustraireMise(int mise) {
        solde -= mise;
    }

    public int getSolde() {
        return solde;
    }
}
