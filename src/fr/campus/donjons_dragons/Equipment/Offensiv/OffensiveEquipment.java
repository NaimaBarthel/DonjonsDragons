package fr.campus.donjons_dragons.Equipment.Offensiv;

/**
 * Classe abstraite pour les équipements offensifs.
 */
public abstract class OffensiveEquipment {
    //Attributes
    private String type;  //"Weapon"  or  "Spell"
    private int attackLevel;  //Level of Attack
    private String name;

    //constructor

    /**
     * Constructeur de l'objet OffensiveEquipment
     *
     * @param offensiveEquipTyp une chaine de caractères, attackLevel un entier, name une chaine de caractères
     * @return une instance de OffensiveEquipment
     */
    public OffensiveEquipment(String offensiveEquipTyp, int attackLevel, String name) {
        this.type = offensiveEquipTyp;
        this.attackLevel = attackLevel;
        this.name = name;
    }

    //Getter

    /**
     * Getter du type de l'équipement offensif
     *
     * @param :
     * @return une chaine de character: le type de l'équipement offensif
     */
    public String getType() {
        return type;
    }

    /**
     * Setter du type de l'équipement offensif
     * @param offensiveEquip une chaine de caractère
     * @return
     */
    public void setType(String offensiveEquip) {
        this.type = offensiveEquip;
    }

    /**
     * Getter du niveau d'attaque de l'équipement offensif
     * @param :
     * @return un entier: le niveau d'attaque de l'équipement offensif
     */
    public int getAttackLevel() {
        return attackLevel;
    }
    //Setters

    /**
     * Setter du niveau d'attaque de l'équipement offensif
     * @param attackLevel une chaine de caractère
     * @return
     */
    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    /**
     * Getter du nom de l'équipement offensif
     * @param :
     * @return une chaine de character: le nom de l'équipement offensif
     */
    public String getName() {
        return name;
    }

    /**
     * Setter du nom de l'équipement offensif
     * @param name une chaine de caractère
     * @return
     */
    public void setName(String name) {
        this.name = name;
    }


    //toString  méthode pour afficher les informations de l'équipememnt d'attaque
    /**
     * Méthode toString qui affiche l' objet OffensiveEquipment
     * @param
     * @return une chaine de caractères
     */
    @Override
    public String toString() {
        return String.format("Offensive Equipment [ Type: %s, Offensive Level: %d, Name: %s]", type, attackLevel, name);
    }


}
