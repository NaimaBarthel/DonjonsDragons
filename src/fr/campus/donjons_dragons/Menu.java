package fr.campus.donjons_dragons;

import java.util.Scanner;

import static fr.campus.donjons_dragons.Game.NUM_TYPE_PLAYER;


public class Menu {
    /**
     * Instance unique de la classe {@code Menu} pattern Singleton
     */
    private static final Menu INSTANCE = new Menu();
    /**
     * Scanner utilisé pour lire les entrées de l'utilisateur.
     * Initialisé avec {@code System.in} pour une lecture depuis la console.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructeur privé pour empêcher l'instanciation externe.
     * Seule l'instance {@link #INSTANCE} est autorisée.
     */
    private Menu() {
    }

    /**
     * Retourne l'instance unique de la classe {@code Menu}.
     *
     * @return l'instance singleton de {@code Menu}
     */
    public static Menu getInstance() {
        return INSTANCE;
    }


    //méthodes

    /**
     * Affiche le message d'introduction du jeu.
     * Exemple de sortie : "Welcome to Donjons & Dragons Game!"
     */
    public void intro() {
        System.out.println("Welcome to Donjons & Dragons Game!");
    }

    /**
     * Demande à l'utilisateur de saisir un entier et le retourne.
     *
     * @param message le message à afficher pour guider l'utilisateur
     * @return l'entier saisi par l'utilisateur qui doit être valide
     *
     */
    public int askPlayerTypeInt(String message) {
        int numPlayer;
        while (true) {

            System.out.println(message);
            numPlayer = scanner.nextInt();
            if (numPlayer >= 1 && numPlayer <= NUM_TYPE_PLAYER) {
                scanner.nextLine();  //nettoie le buffer
                return numPlayer;
            } else {
                System.out.println("Erreur : veuillez saisir un nombre entre 1 et " + NUM_TYPE_PLAYER);
            }
        }

    }

    /**
     * Demande à l'utilisateur de saisir du texte (du nom par exemple)
     *
     * @param message le message à afficher pour guider l'utilisateur
     * @return une chaine de caractère saisie par l'utilisateur
     *
     */
    public String askPlayerString(String message) {
        System.out.print(message);
        String messInput = scanner.nextLine();
        if (messInput.equalsIgnoreCase("Q")) {
            System.exit(0);
        }
        return messInput;
    }

    public boolean askModifyCharacter() {
        //boolean modif = false;

        while (true) {
            String response = askPlayerString("Voulez-vous modifier les infos de votre personnage?O/N");
            if (response.equalsIgnoreCase("o")) {
                return true;
            } else if (response.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Erreur: veuillez saisir 'O' ou 'N'.");
            }
        }
    }


}
