package fr.campus.donjons_dragons.Game;

import fr.campus.donjons_dragons.Character.Character;
import fr.campus.donjons_dragons.Character.Warrior;
import fr.campus.donjons_dragons.Character.Wizard;

import java.util.Scanner;

/**
 * Classe Game qui contient la logique interne du jeu
 */
public class Game {
    //Attributes
    public static final int NUM_TYPE_PLAYER = 2;
    private final Menu menu = Menu.getInstance();
    private final Dice dice = new Dice();
    private final Board board = new Board();
    private final Scanner scanner = new Scanner(System.in);
    private fr.campus.donjons_dragons.Character.Character player;

    /**
     * Constructeur
     * où on initialise le jeu en lançant le menu
     */
    public Game() {
    }


    /**
     * Getter pour le personnage.
     *
     * @return le personnage actuel
     */
    public Character getPlayer() {
        return player;
    }

    /**
     * Méthode principale qui permet de lancer le jeu,
     * affiche le menu pour créer un personnage
     */
    /*public void start() {
        menu.intro();
        while (menu.askToStartAGame()) {
            createPlayer();
            displayPlayer();
            modifyPlayer();
            playGame();
        }
        System.out.println("A bientôt!!!");
    } */
    public void start() {
        boolean running = true;
        menu.intro();
        if (menu.askToStartAGame()) {
            while (running) {

                createPlayer();
                displayPlayer();
                modifyPlayer();
                playGame();
                running = menu.askToReStartAGame();
            }
            System.out.println("A bientôt!!!");
        }

    }


    /**
     * Méthode qui permet de faire un tour de jeu
     * c-à-d lancer le dé + déplacer le joueur + afficher sa position
     */
    private void playTurn() {
        System.out.println("Pour lancer le dé appuyer sur la touche Entrée...");
        scanner.nextLine();  //Attend appui Entrée

        int roll = dice.roll();  //lancé de dés
        int newPosition = roll + player.getPosition();

        if (board.isFinished(newPosition))    //Si arrivé à, ou dépassé 64 (SIZE), on se place à l'arrivée (SIZE)
            newPosition = Board.SIZE;   //arrivée à 64

        player.setPosition(newPosition);  //déplacer joueur
        System.out.print("Lancé de dé = " + roll + ".");  //affichage du lancé
        displayPlayerOnBoard(newPosition);  //Affichage position joueur
    }

    /**
     * Méthode qui permet de lancer une partie
     * c-à-d lancer le dé tant qu'on est pas arrivé à la dernière case
     */
    private void playGame() {
        System.out.print("Partie démarrée !!!");
        displayPlayerOnBoard(player.getPosition());   //Affichage position joueur

        //tant que le joueur n'est pas arrivé à la case 64
        while (!board.isFinished(player.getPosition())) {
            playTurn();                               //on joue un tour: on lance le dé et déplace le joueur
        }
        //Sortie de boucle = Arrivée à 64
        System.out.print("Bravo!! ");
        displayPlayerOnBoard(player.getPosition());  //Affichage position joueur
        System.out.println("Partie terminée.");
    }

    /**
     * Méthode qui permet de créer un personnage
     * on demande à l'utilisateur de choisir le type de personnage "Warrior" ou "Wizard"
     * et de lui donner un nom
     */
    private void createPlayer() {
        //Demander le type de joueur "Warrior" ou "Wizard"
        String chosenType = "";
        do {
            chosenType = menu.askPlayerString("Choisissez le type de personnage:\n1. Warrior\n2. Wizard\n>");
            System.out.println(chosenType);

        } while (!chosenType.matches("^[1-2]$"));

        //Demander le nom du joueur;
        String chosenName = "";
        do {
            chosenName = menu.askPlayerString("Saisissez le nom de votre personnage:\n>");
            System.out.println(chosenName);

        } while (!chosenName.matches("^[\\p{L}-]+$"));

        //création du joueur demandé
        //Création du personnage en fonction des choix saisis

        if (chosenType.equals("1")) {
            player = new Warrior(chosenName);
        } else //(chosenType == 2)
        {
            player = new Wizard(chosenName);
        }

        System.out.println("Personnage créé : " + player);
    }

    /**
     * Méthode qui permet d'afficher le personnage
     *
     */
    public void displayPlayer() {
        System.out.println("Mon personnage : " + this.player.toString());
    }

    /**
     * Méthode qui permet d'afficher le personnage
     *
     */
    public void displayPlayerOnBoard(int position) {
        System.out.println("Position joueur " + player.getName() + " : " + position + "/" + Board.SIZE);
    }


    /**
     * Méthode qui permet de modifier un personnage
     * on demande à l'utilisateur si on modifie le nom ou le type ou rien(on quitte)
     */
    public void modifyPlayer() {
        boolean modifyChar = menu.askModifyCharacter();
        //modifyChar = true => on permet la modification du nom et du type
        if (modifyChar) {
            // on créé un nouveau personnage
            createPlayer();
        }
        //si modifyChar = false => on fait rien, on sort
    }

}
