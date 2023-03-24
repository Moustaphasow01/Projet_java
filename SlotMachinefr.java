import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SlotMachine {
    private final int numOfReels;
    private final int selectionsPerReel;
    private final int costPerReel;
    private int balance;
    private final int viewBox;
    private final int costPerPayline;
    private final int paylineReward;
    
    // Les noms des paylines
    private static final List<String> PAYLINE_NAMES = Arrays.asList(
        "Top Line",
        "Middle Line",
        "Bottom Line",
        "Three line 'W'",
        "Three line 'M'",
        "Upward 'V'",
        "Downward 'V'"
    );
    
    // Constructeur
    public SlotMachine(int numOfReels, int selectionsPerReel, int costPerReel, int balance, int viewBox, int paylineReward) {
        this.numOfReels = numOfReels;
        this.selectionsPerReel = selectionsPerReel;
        this.costPerReel = costPerReel;
        this.balance = balance;
        this.viewBox = viewBox;
        this.costPerPayline = this.costPerReel * this.numOfReels;
        this.paylineReward = paylineReward;
        
        // Vérifier les conditions pour pouvoir jouer
        if (this.numOfReels < 3 || this.selectionsPerReel < 3 || this.viewBox % 2 == 0) {
            throw new IllegalArgumentException("The machine is not ready to play.");
        }
        
        System.out.println(toString());
        
        // Boucle de jeu
        while (this.balance >= this.costPerPayline) {
            spin();
        }
        
        System.out.println("Game Over!!");
    }
    
    // Méthode de spin
    private void spin() {
        Scanner scanner = new Scanner(System.in);
        
        // Afficher les paylines
        System.out.println(getPaylines());
        
        // Demander les paylines sélectionnées
        System.out.println("Please enter the numbers of the paylines you want, separated by commas, and press enter to play!");
        String[] paylinesSelected = scanner.next().split(",");
        
        // Calculer le coût de la spin
        int spinCost = paylinesSelected.length * this.costPerPayline;
        
        // Vérifier si le joueur a assez d'argent pour jouer
        if (spinCost > this.balance) {
            System.out.println("You do not have enough to make this bet");
            return;
        }
        
        // Obtenir les résultats de la spin
        int[][] spinResults = getSpinResults();
        
        // Vérifier s'il y a des gagnants
        checkForWinners(paylinesSelected, spinResults);
        
        // Afficher les résultats
        for (int[] spinResult : spinResults) {
            System.out.println(Arrays.toString(spinResult));
        }
        
        // Déduire le coût de la spin du solde du joueur
        this.balance -= spinCost;
        System.out.println("This spin cost you: " + spinCost);
        System.out.println("Your Balance is now : " + this.balance);
    }
    
    // Méthode pour obtenir les noms des paylines
    private String getPaylines() {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < PAY
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SlotMachine {
    private final int numOfReels;
    private final int selectionsPerReel;
    private final int costPerReel;
    private int balance;
    private final int viewBox;
    private final int costPerPayline;
    private final int paylineReward;
    
    // Les noms des paylines
    private static final List<String> PAYLINE_NAMES = Arrays.asList(
        "Top Line",
        "Middle Line",
        "Bottom Line",
        "Three line 'W'",
        "Three line 'M'",
        "Upward 'V'",
        "Downward 'V'"
    );
    
    // Constructeur
    public SlotMachine(int numOfReels, int selectionsPerReel, int costPerReel, int balance, int viewBox, int paylineReward) {
        this.numOfReels = numOfReels;
        this.selectionsPerReel = selectionsPerReel;
        this.costPerReel = costPerReel;
        this.balance = balance;
        this.viewBox = viewBox;
        this.costPerPayline = this.costPerReel * this.numOfReels;
        this.paylineReward = paylineReward;
        
        // Vérifier les conditions pour pouvoir jouer
        if (this.numOfReels < 3 || this.selectionsPerReel < 3 || this.viewBox % 2 == 0) {
            throw new IllegalArgumentException("The machine is not ready to play.");
        }
        
        System.out.println(toString());
        
        // Boucle de jeu
        while (this.balance >= this.costPerPayline) {
            spin();
        }
        
        System.out.println("Game Over!!");
    }
    
    // Méthode de spin
    private void spin() {
        Scanner scanner = new Scanner(System.in);
        
        // Afficher les paylines
        System.out.println(getPaylines());
        
        // Demander les paylines sélectionnées
        System.out.println("Please enter the numbers of the paylines you want, separated by commas, and press enter to play!");
        String[] paylinesSelected = scanner.next().split(",");
        
        // Calculer le coût de la spin
        int spinCost = paylinesSelected.length * this.costPerPayline;
        
        // Vérifier si le joueur a assez d'argent pour jouer
        if (spinCost > this.balance) {
            System.out.println("You do not have enough to make this bet");
            return;
        }
        
        // Obtenir les résultats de la spin
        int[][] spinResults = getSpinResults();
        
        // Vérifier s'il y a des gagnants
        checkForWinners(paylinesSelected, spinResults);
        
        // Afficher les résultats
        for (int[] spinResult : spinResults) {
            System.out.println(Arrays.toString(spinResult));
        }
        
        // Déduire le coût de la spin du solde du joueur
        this.balance -= spinCost;
        System.out.println("This spin cost you: " + spinCost);
        System.out.println("Your Balance is now : " + this.balance);
    }
    
    // Méthode pour obtenir les noms des paylines
    private String getPaylines() {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < PAY
