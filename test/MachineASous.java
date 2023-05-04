package test;

import java.util.ArrayList;
import java.util.List;

public class MachineASous {
    private ArrayList<Rouleau> rouleaux;
    private Joueur joueur;
    private Bonus bonus;
    private Free free;
    private boolean partieBonus;
    private boolean toursGratuits;
    private List<Colonne> colonnes;
    private TableDeGains tableDeGains;

    public MachineASous() {
        rouleaux = new ArrayList<>();
        joueur = new Joueur(250000);
        bonus = new Bonus();
        free = new Free();

        // Initialiser les rouleaux
        for (int i = 0; i < 4; i++) {
            rouleaux.add(new Rouleau(30));
        }
        rouleaux.add(new Rouleau(41));

        // Générer les symboles pour chaque rouleau
        for (Rouleau rouleau : rouleaux) {
            rouleau.genererSymboles();
            
        }
        colonnes = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Rouleau rouleau = new Rouleau(10);
            rouleau.genererSymboles();
            colonnes.add(new Colonne(rouleau));
        }

            tableDeGains = new TableDeGains();
        }
    


    public Joueur getJoueur() {
        return joueur;
    }


public int jouer(int mise, Joueur joueur) {
    // Vérifiez si le joueur a suffisamment de fonds pour miser
    if (joueur.getSolde() < mise) {
        System.out.println("Solde insuffisant pour miser !");
        return 0;
    }
    
    
    

    this.joueur.retirerMise(mise);


    // Générer les symboles pour chaque rouleau
    for (Rouleau rouleau : rouleaux) {
        rouleau.genererSymboles();
    }
    
    for (Colonne colonne : colonnes) {
        colonne.tourner();
    }

    // Implémentez la logique pour vérifier les victoires, gérer les symboles spéciaux "Super", "Free" et "Bonus"
    // ...

    // Calculez les gains du joueur pour cette partie
    int gains = 0;

    // ...
    
    // Ajoutez les gains au solde du joueur
    joueur.ajouterGains(gains);

    return gains;
}

public void afficherResultat() {
    for (Colonne colonne : colonnes) {
        colonne.afficher();
    }
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

