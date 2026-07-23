package fr.campus.donjons_dragons;

/**
 * Classe Game qui contient la logique interne du jeu
 */
public class Game {
    //Attributes
    public static final int NUM_TYPE_PLAYER = 2;
    private Character player;
    private Menu menu = Menu.getInstance();


    /**
     * Constructeur
     * où on initialise le jeu en lançant le menu
     */
    public Game() {
    }

     /**
     * Getter pour le personnage.
     * @return le personnage actuel
     */
    public Character getPlayer() {
        return player;
    }

    /**
     * Méthode principale qui permet de lancer le jeu,
     * affiche le menu pour créer un personnage
     */
    public void start() {
        menu.intro();
        createPlayer();
        displayPlayer();
        modifyPlayer();
    }

    /**
     * Méthode qui permet de créer un personnage
     * on demande à l'utilisateur de choisir le type de personnage "Warrior" ou "Wizard"
     * et de lui donner un nom
     */
    public void createPlayer() {
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

        System.out.println("Personnage créé : " + player.toString());
    }

    /**
     * Méthode qui permet d'afficher le personnage
     *
     */
    public void displayPlayer() {
        System.out.println("Mon personnage : " + this.player.toString());
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
