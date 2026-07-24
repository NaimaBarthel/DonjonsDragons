package fr.campus.donjons_dragons.Equipment.Defensiv;

/**
 * classe représentant une potion (spécifique aux Magiciens).
 * Hérite de DefensiveEquipment
 */
public class Potion extends DefensiveEquipment {
    /**
     * Constructeur de Potion.
     * @param defenseLevel Niveau de défense de la potion
     * @param name Nom de la potion.
     */
    public Potion(int defenseLevel, String name){
        super("Potion",defenseLevel, name);
    }

    /**
     * Méthode toString qui affiche l' objet DefensiveEquipment Potion
     * @param
     * @return une chaine de caractères
     */
    public String toString(){
        return String.format("%s  Defensive Level= %d, Name= %s", super.getType(),super.getDefenseLevel(),super.getName());
    }
}
