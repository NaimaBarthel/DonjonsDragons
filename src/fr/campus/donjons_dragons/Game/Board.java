package fr.campus.donjons_dragons.Game;

import fr.campus.donjons_dragons.Main;
import fr.campus.donjons_dragons.OutOfBoardException;
import java.util.ArrayList;

/**
 * Classe Board qui représente le plateau de jeu de 64 cases
 */
public class Board {
    //Attributes
    public static final int SIZE = 64;   //Taille fixe du tableau
   // private final Cell[] cells;  //Tableau de 64 case
    private final ArrayList<Cell> cells;

    /**
     * Constructeur
     * où on initialise le plateau avec 64 cases(cellules)
     */
    public Board() {
        //cells = new Cell[SIZE];
        cells = new ArrayList<Cell>();
        for (int i = 0; i < SIZE; i++) {
            //cells[i] = new Cell(i + 1);
            cells.add(new EmptyCell(i+1));
        }
    }

    /**
     * Méthode qui permet de savoir si la partie est finie ou non
     *
     * @param position un entier représentant la position du joueur
     * @return booléen vrai si le joueur est sur la case 64 (= SIZE)
     */
    public boolean isFinished(int position) {
        return position == SIZE;
    }


    /**
     * Méthode qui vérifie si la position du joueur est <= SIZE
     *
     * @param position un entier représentant la position du joueur
     * @throws OutOfBoardException si la position dépasse SIZE
     */
    public void checkPosition( int position) throws OutOfBoardException {
        if (position > SIZE  ) {
              throw new OutOfBoardException("Position " + position + " > " + SIZE + ". ");

        }
    }

}
