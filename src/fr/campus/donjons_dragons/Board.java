package fr.campus.donjons_dragons;

/**
 * Classe Board qui représente le plateau de jeu de 64 cases
 */
public class Board {
    //Attributes
    public static final int SIZE = 64;   //Taille fixe du tableau
    private Cell[] cells;  //Tableau de 64 case

    /**
     * Constructeur
     * où on initialise le plateau avec 64 cases(cellules)
     */
    public Board() {
        cells = new Cell[SIZE];
        for (int i = 0; i< SIZE; i++) {
            cells[i] = new Cell(i+1);
        }
    }
}
