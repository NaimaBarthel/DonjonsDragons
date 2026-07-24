package fr.campus.donjons_dragons.Equipment.Defensiv;

/**
 * classe représentant un bouclier (spécifique aux Guerriers).
 * Hérite de DefensiveEquipment
 */
public class Shield extends DefensiveEquipment {
    /**
     * Constructeur de Shield.
     * @param defenseLevel Niveau de défense du bouclier
     * @param name Nom de du sort.
     */
    public Shield(int defenseLevel, String name){
        super("Shield", defenseLevel, name);
    }

    /**
     * Méthode toString qui affiche l' objet DefensiveEquipment Shield
     * @param
     * @return une chaine de caractères
     */
    public String toString(){
        return String.format("%s  Defensive Level: %d, Name: %s", super.getType(),super.getDefenseLevel(),super.getName());
    }
}
