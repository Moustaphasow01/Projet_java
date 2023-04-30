package src;

public class Joueur {
    private int solde;

    public Joueur(int solde) {
        this.solde = solde;
    }

    public int getSolde() {
        return solde;
    }

    public void ajouterSolde(int montant) {
        solde += montant;
    }

    public void soustraireSolde(int montant) {
        solde -= montant;
    }
}
