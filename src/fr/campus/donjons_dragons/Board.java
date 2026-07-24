package fr.campus.donjons_dragons;

/**
 * Classe Board qui représente le plateau de jeu de 64 cases
 */
public class Board {
    //Attributes
    public static final int SIZE = 64;   //Taille fixe du tableau
    private final Cell[] cells;  //Tableau de 64 case

    /**
     * Constructeur
     * où on initialise le plateau avec 64 cases(cellules)
     */
    public Board() {
        cells = new Cell[SIZE];
        for (int i = 0; i < SIZE; i++) {
            cells[i] = new Cell(i + 1);
        }
    }

    /**
     * Méthode qui permet de savoir si la partie est finie ou non
     *
     * @param position un entier représentant la position du joueur
     * @return booléen vrai si le joueur est sur la case 64 (= SIZE) ou l'a dépassée
     */
    public boolean isFinished(int position) {
        return position >= SIZE;
    }
}
