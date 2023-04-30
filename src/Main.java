package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MachineASous machineASous = new MachineASous();

        System.out.println("Bienvenue dans la machine à sous !");
        boolean continuerJeu = true;

        while (continuerJeu) {
            System.out.println("Votre solde est de : " + machineASous.getJoueur().getSolde());
            System.out.println("Choisissez votre mise (2K, 4K, 6K, 10K) ou tapez 'q' pour quitter : ");
            String choixMise = scanner.next().toLowerCase();
            int mise;

            switch (choixMise) {
                case "2k":
                    mise = 2000;
                    break;
                case "4k":
                    mise = 4000;
                    break;
                case "6k":
                    mise = 6000;
                    break;
                case "10k":
                    mise = 10000;
                    break;
                case "q":
                    continuerJeu = false;
                    System.out.println("Merci d'avoir joué !");
                    continue;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une mise valide.");
                    continue;
            }

            int gains = machineASous.jouer(mise, machineASous.getJoueur());
            System.out.println("Vous avez gagné : " + gains);
            machineASous.getJoueur().ajouterGains(gains);

            if (machineASous.isPartieBonus()) {
                System.out.println("Vous avez déclenché la partie bonus !");
            
                // Demander au joueur de choisir une case
                System.out.println("Choisissez une case (1-20) :");
                int choix = scanner.nextInt();
            
                // Créer une instance de la classe Bonus
                Bonus bonus = machineASous.getBonus();
                int gainBonus = bonus.choisirCase(choix, mise);
            
                // Mettre à jour le solde du joueur
                joueur.ajouterGain(gainBonus);
            
                // Afficher les gains de la partie bonus
                System.out.println("Vous avez gagné " + gainBonus + " !");
            }

            // Si les tours gratuits sont déclenchés
            if (machineASous.isToursGratuits()) {
                // Ajoutez ici la logique pour gérer les tours gratuits, demander au joueur de choisir un nombre de tours, calculer les gains, etc.
                // ...
            }
        }

        scanner.close();
    }
}
