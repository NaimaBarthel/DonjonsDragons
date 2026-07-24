package fr.campus.donjons_dragons.Equipment.Offensiv;

/**
 * classe représentant une arme (spécifique aux Guerriers).
 * Hérite de OffensiveEquipment.
 */
public class Weapon extends OffensiveEquipment {
     /**
     * Constructeur de Weapon.
     * @param attackLevel Niveau d'attaque de l'arme.
     * @param name Nom de l'arme.
     */
    public Weapon(int attackLevel, String name){
        super("Weapon", attackLevel,name);
    }

    /**
     * Méthode toString qui affiche l' objet OffensiveEquipment Weapon
     * @param
     * @return une chaine de caractères
     */
    public String toString(){
        return String.format("%s  Offensive Level: %d, Name: %s", super.getType(),super.getAttackLevel(),super.getName());
    }
}
