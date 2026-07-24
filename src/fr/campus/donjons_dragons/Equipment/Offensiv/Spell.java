package fr.campus.donjons_dragons.Equipment.Offensiv;

/**
 * classe représentant un sort (spécifique aux Magiciens).
 * Hérite de OffensiveEquipment.
 */
public class Spell extends OffensiveEquipment {
   /**
     * Constructeur de Spell.
     * @param attackLevel Niveau d'attaque du sort.
     * @param name Nom de du sort.
     */
    public Spell(int attackLevel, String name){
        super("Spell", attackLevel,name);
    }


    /**
     * Méthode toString qui affiche l' objet OffensiveEquipment Weapon
     * @param
     * @return une chaine de caractères
     */
    public String toString(){
        return String.format("%s Offensive Level: %d, Name: %s", super.getType(),super.getAttackLevel(),super.getName());
    }

}
