package fr.campus.donjons_dragons.Game;

/**
 * @ClassName SpellCell
 * @Description TODO
 * @Author Naima Barthel
 * @Date 27/07/2026 16:05
 * @Version 1.0
 */
public class SpellCell extends Cell{
    /**
     * Constructeur d'une case Arme
     *
     * @param position entier qui représente la position de la case sur le plateau
     */
    public SpellCell(int position){
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
        return String.format("Case  %d : Potion",getPosition());
    }
}