package fr.campus.donjons_dragons.Game;

/**
 * @ClassName EnemyCell
 * @Description TODO
 * @Author Naima Barthel
 * @Date 27/07/2026 14:57
 * @Version 1.0
 */
public class EnemyCell extends Cell{
    /**
     * Constructeur d'une case ennemi
     *
     * @param position entier qui représente la position de la case sur le plateau
     */
    public EnemyCell(int position){
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
        return String.format("Case %d : Ennemi",getPosition());
    }

}