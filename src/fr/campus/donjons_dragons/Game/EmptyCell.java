package fr.campus.donjons_dragons.Game;

/**
 * @ClassName EmptyCell
 * @Description TODO
 * @Author Naima Barthel
 * @Date 27/07/2026 14:37
 * @Version 1.0
 */
public class EmptyCell extends Cell {
    /**
     * Constructeur d'une case vide
     * rien ne se passe quand un personnage passe dessus
     * @param position entier qui représente la position de la case sur le plateau
     */
    public EmptyCell(int position){
        super(position);
    }

    /**
     * Méthode toString qui affiche une case vide
     *
     * @param
     * @return une chaine de character
     */
    @Override
    public String toString(){
        return String.format("Case  %d : vide",getPosition());
    }

}