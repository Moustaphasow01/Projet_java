package src;

import java.util.ArrayList;

public class MachineASous {
    private ArrayList<Rouleau> rouleaux;
    private Joueur joueur;
    private Bonus bonus;
    private Free free;
    private boolean partieBonus;
    private boolean toursGratuits;

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
    }

    public int jouer(int mise, Joueur joueur) {
        // Vérifiez si le joueur a suffisamment de fonds pour miser
        if (joueur.getSolde() < mise) {
            System.out.println("Solde insuffisant pour miser !");
            return 0;
        }
    
        joueur.retirerMise(mise);
    
        // Générer les symboles pour chaque rouleau
        for (Rouleau rouleau : rouleaux) {
            rouleau.genererSymboles();
        }
    

// Implémentez la logique pour vérifier les victoires, gérer les symboles spéciaux "Super", "Free" et "Bonus"
int nombreDeSuper = 0;
int nombreDeFree = 0;
int nombreDeBonus = 0;

// Parcourez les rouleaux et les lignes pour compter les symboles spéciaux
for (int i = 0; i < rouleaux.size(); i++) {
    Rouleau rouleau = rouleaux.get(i);
    for (int j = 0; j < rouleau.getLignes().size(); j++) {
        Symbole symbole = rouleau.getLignes().get(j);

        if (symbole == Symbole.SUPER) {
            nombreDeSuper++;
        } else if (symbole == Symbole.FREE) {
            nombreDeFree++;
        } else if (symbole == Symbole.BONUS) {
            nombreDeBonus++;
        }
    }
}

if (nombreDeSuper > 0) {
    // Gérer le symbole "Super"
    int symboleNormal = 0;

    // Trouver un symbole normal aléatoire sur les rouleaux 1, 2, 4 et 5
    while (symboleNormal == 0) {
        int indexRouleau = (int) (Math.random() * 4);
        Rouleau rouleau = rouleaux.get(indexRouleau);
        Symbole symbole = rouleau.getLignes().get(0);
        if (symbole != Symbole.SUPER && symbole != Symbole.FREE && symbole != Symbole.BONUS) {
            symboleNormal = symbole.getValeur();
        }
    }

    // Remplacer tous les symboles "Super" par le symbole normal
    for (int i = 0; i < rouleaux.size(); i++) {
        Rouleau rouleau = rouleaux.get(i);
        for (int j = 0; j < rouleau.getLignes().size(); j++) {
            Symbole symbole = rouleau.getLignes().get(j);
            if (symbole == Symbole.SUPER) {
                rouleau.getLignes().set(j, Symbole.getSymbole(symboleNormal));
            }
        }
    }
}


if (nombreDeFree >= 3) {
    // Gérer le symbole "Free"
    int toursGratuits = 0;
    int multiplicateur = 0;

    // Demander au joueur de choisir le nombre de tours gratuits et le multiplicateur
    System.out.println("Vous avez déclenché les tours gratuits !");
    System.out.println("Combien de tours gratuits voulez-vous ? (5/10/15)");
    int choixToursGratuits = scanner.nextInt();
    while (choixToursGratuits != 5 && choixToursGratuits != 10 && choixToursGratuits != 15) {
        System.out.println("Veuillez choisir un nombre de tours gratuits valide (5/10/15) :");
        choixToursGratuits = scanner.nextInt();
    }
    toursGratuits = choixToursGratuits;

    System.out.println("Avec quel multiplicateur ? (2/3/6)");
    int choixMultiplicateur = scanner.nextInt();
    while (choixMultiplicateur != 2 && choixMultiplicateur != 3 && choixMultiplicateur != 6) {
        System.out.println("Veuillez choisir un multiplicateur valide (2/3/6) :");
        choixMultiplicateur = scanner.nextInt();
    }
    multiplicateur = choixMultiplicateur;

    // Déclencher les tours gratuits
    // ...
}

if (nombreDeBonus >= 3) {
    // Gérer le symbole "Bonus"
    // Déclencher la partie bonus
    // ...
}
// ...


    
        // Calculez les gains du joueur pour cette partie
        int gains = 0;
    
        // ...
        
        // Ajoutez les gains au solde du joueur
        joueur.ajouterGains(gains);
    
        return gains;
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

