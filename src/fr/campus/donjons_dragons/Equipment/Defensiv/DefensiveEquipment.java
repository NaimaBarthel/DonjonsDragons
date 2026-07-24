package fr.campus.donjons_dragons.Equipment.Defensiv;

/**
 * Classe abstraite pour les équipements défensifs.
 */
public abstract class DefensiveEquipment {
    //Attributs
    private String type;  //"Shield" or "Potion"
    private int defenseLevel;   // Level of defense
    private String name;    //nom de l'équipement

    //Constructor
    /**
     * Constructeur de l'objet DefensiveEquipment
     *
     * @param defensiveEquipTyp une chaine de caractères, defenseLevel un entier, name une chaine de caractères
     * @return une instance de DefensiveEquipment
     */
    public DefensiveEquipment(String defensiveEquipTyp, int defenseLevel, String name) {
        this.type = defensiveEquipTyp;
        this.defenseLevel = defenseLevel;
        this.name = name;
    }

    //Getter
    /**
     * Getter du type de l'équipement défensif
     *
     * @param :
     * @return une chaine de character: le type de l'équipement défensif
     */
    public String getType() {
        return type;
    }

    /**
     * Setter du type de l'équipement défensif
     * @param defensiveEquip une chaine de caractère
     * @return
     */
    public void setType(String defensiveEquip) {
        this.type = defensiveEquip;
    }

    /**
     * Getter du niveau de défense de l'équipement défense
     * @param :
     * @return un entier: le niveau de défense de l'équipement défensif
     */
    public int getDefenseLevel() {
        return defenseLevel;
    }

    /**
     * Setter du niveau de défense de l'équipement défensif
     * @param defenseLevel une chaine de caractère
     * @return
     */
    public void setDefenseLevel(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }

    /**
     * Getter du nom de l'équipement défensif
     * @param :
     * @return une chaine de character: le nom de l'équipement défensif
     */
    public String getName() {
        return name;
    }

    /**
     * Setter du nom de l'équipement défensif
     * @param name une chaine de caractère
     * @return
     */
    public void setName(String name) {
        this.name = name;
    }

    //toString méthode pour afficher les informations de l'équipement de défense
    /**
     * Méthode toString qui affiche l' objet DefensiveEquipment
     * @param
     * @return une chaine de caractères
     */
    public String toString() {
        return String.format("Defensive Equipment [ Type: %s, Defense Level: %d, Name: %s]", type, defenseLevel, name);
    }
}
