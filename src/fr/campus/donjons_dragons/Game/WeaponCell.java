package fr.campus.donjons_dragons.Game;

/**
 * @ClassName WeaponCell
 * @Description TODO
 * @Author Naima Barthel
 * @Date 27/07/2026 16:03
 * @Version 1.0
 */
public class WeaponCell extends Cell{
    /**
     * Constructeur d'une case Arme
     *
     * @param position entier qui représente la position de la case sur le plateau
     */
    public WeaponCell(int position){
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
        return String.format("Case  %d : Arme",getPosition());
    }

}