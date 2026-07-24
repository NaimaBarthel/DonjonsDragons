package fr.campus.donjons_dragons.Game;

/**
 * Classe Cell représente une case du plateau
 *
 * @param index position de la case (1 à 64)
 */
public record Cell(int index) {
    /**
     * Constructeur d'une cellule
     *
     * @param index entier qui représente une case du plateau
     */
    public Cell {
    }

    /**
     * Getter de l'index
     *
     * @param
     * @return un entier: le numéro de case de la cellule
     */
    @Override
    public int index() {
        return index;
    }


}
