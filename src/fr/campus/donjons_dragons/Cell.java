package fr.campus.donjons_dragons;

/**
 * Classe Cell représente une case du plateau
 */
public class Cell
{
    private final int index;   //position de la case (1 à 64)

    /**
     * Constructeur d'une cellule
     * @param index entier qui représente une case du plateau
     */
    public Cell(int index){
        this.index = index;
    }

    /**
     * Getter de l'index
     *
     * @param
     * @return un entier: le numéro de case de la cellule
     */
    public int getIndex(){
        return index;
    }


}
