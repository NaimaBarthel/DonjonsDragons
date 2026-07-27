package fr.campus.donjons_dragons.Game;

/**
 * Classe Cell représente une case du plateau
 *
 */
public abstract class Cell{
    private int position;   //position de la case (de 1 à 64)
    /**
     * Constructeur d'une cellule
     * @param position entier qui représente une case du plateau
     */
    public Cell(int position) {
        this.position = position;
    }

    /**
     * Getter de la position : retourne la position de la case
     *
     * @param
     * @return un entier: le numéro de case de la cellule
     */
     public int getPosition() {
        return position;
    }

    /**
     * Méthode toString qui affiche le numéro de la case
     *
     * @param
     * @return une chaine de caractères
     */
     public abstract String toString();


}
