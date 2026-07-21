package fr.campus.donjons_dragons;
import java.util.InputMismatchException;
import java.util.Scanner;

import static fr.campus.donjons_dragons.Game.NUM_TYPE_PLAYER;


public class Menu {
    /**
     * Instance unique de la classe {@code Menu} pattern Singleton
     */
    private static final Menu INSTANCE = new Menu();
    /**
     * Retourne l'instance unique de la classe {@code Menu}.
     * @return l'instance singleton de {@code Menu}
     */
    public static Menu getInstance(){
        return INSTANCE;
    }

    /**
     * Scanner utilisé pour lire les entrées de l'utilisateur.
     * Initialisé avec {@code System.in} pour une lecture depuis la console.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructeur privé pour empêcher l'instanciation externe.
     * Seule l'instance {@link #INSTANCE} est autorisée.
     */
    public Menu() {}


    //méthodes
    /**
     * Affiche le message d'introduction du jeu.
     * Exemple de sortie : "Welcome to Donjons & Dragons Game!"
     */
    public void intro(){
        System.out.println("Welcome to Donjons & Dragons Game!");
    }

    /**
     * Demande à l'utilisateur de saisir un entier et le retourne.
     *
     * @param message le message à afficher pour guider l'utilisateur
     * @return l'entier saisi par l'utilisateur qui doit être valide
     *
     */
    public int askPlayerInt(String message){
        int numPlayer;
        while(true) {

                System.out.println(message);
                numPlayer = scanner.nextInt();
                if( numPlayer >=1 && numPlayer <= NUM_TYPE_PLAYER){
                    scanner.nextLine();  //nettoie le buffer
                    return numPlayer;
                }
                else{
                    System.out.println("Erreur : veuillez saisir un nombre entre 1 et " );
                }
            }

    }

    /**
     * Demande à l'utilisateur de saisir un nom.
     *
     * @param message le message à afficher pour guider l'utilisateur
     * @return une chaine de caractère saisi par l'utilisateur
     *
     */
    public String askPlayerName(String message){
        String messInput;
        System.out.println(message);
        messInput = scanner.nextLine();

        return messInput;
    }

    public boolean askModifyAttributes(){
        boolean modif = false;

        while(true) {

            System.out.println("Voulez-vous modifier les infos de votre personnage?O/N");
            numPlayer = scanner.nextInt();
            if( numPlayer >=1 && numPlayer <= NUM_TYPE_PLAYER){
                scanner.nextLine();  //nettoie le buffer
                return numPlayer;
            }
            else{
                System.out.println("Erreur : veuillez saisir un nombre entre 1 et " );
            }
        }
    }



}
