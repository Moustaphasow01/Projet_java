package test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MachineASous machineASous = new MachineASous();

        System.out.println("Bienvenue dans la machine a sous !");
        boolean continuerJeu = true;

        while (continuerJeu) {
            System.out.println("Votre solde est de : " + machineASous.getJoueur().getSolde());
            System.out.println("Choisissez votre mise (2000, 4000, 6000, 10000) ou tapez 'q' pour quitter : ");
            String choixMise = scanner.next();
            int mise;
            
            switch (choixMise) {
                case "2000":
                    mise = 2000;
                    break;
                case "4000":
                    mise = 4000;
                    break;
                case "6000":
                    mise = 6000;
                    break;
                case "10000":
                    mise = 10000;
                    break;
                case "q":
                    continuerJeu = false;
                    System.out.println("Merci d'avoir joue !");
                    continue;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une mise valide.");
                    continue;
            }

            int gains = machineASous.jouer(mise, machineASous.getJoueur());
          
            machineASous.getJoueur().ajouterGains(gains);

            if (machineASous.isPartieBonus()) {
                System.out.println("Vous avez declenche la partie bonus !");

                // Demander au joueur de choisir une case
                System.out.println("Choisissez une case (1-20) :");
                int choix = scanner.nextInt();
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