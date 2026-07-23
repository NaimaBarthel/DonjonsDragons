package fr.campus.donjons_dragons;

public abstract class Character {

    //Attributes
    //private String typeCharacter;  //type Character : Warrior or Wizard
    private String name;
    private int levelLife;
    private int levelAttack;
    private OffensiveEquipment offensiveEquip;

    //constructor
    /**
     * Constructeur de l'objet Character
     * @param name le nom du personnage, leveLife
     * @return une instance de Character
     */
    public Character(String name, int leveLife, int levelAttack, OffensiveEquipment offensiveEquip) {
        //this.typeCharacter = typeChar;
        this.name = name;
        this.levelLife = leveLife;
        this.levelAttack = levelAttack;
        this.offensiveEquip = offensiveEquip;
    }


    //Getters
    /**
     * Getter du nom du personnage
     * @param :
     * @return une chaine de character: le nom du personnage
     */
    public String getName() {
        return name;
    }

    /**
     * Getter du niveau de vie du personnage
     * @param :
     * @return un entier: le niveau de vie du personnage
     */
    public int getLevelLife() {
        return levelLife;
    }

    /**
     * Getter du niveau d'attaque du personnage
     * @param :
     * @return un entier: le niveau d'attaque du personnage
     */
    public int getLevelAttack() {
        return levelAttack;
    }
    public OffensiveEquipment getOffensiveEquip() {
        return offensiveEquip;
    }

    //Setters
    /**
     * Setter du nom du personnage
     * @param :name une chaine de caractère
     * @return
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter du niveau de vie du personnage
     * @param leveLife un entier
     * @return
     */
    public void setLevelLife(int leveLife) {
        //verify to avoid negative points
        if (leveLife >= 0) {
            this.levelLife = leveLife;
        } else {
            this.levelLife = 0;  // if < 0, =0
        }
    }


    /**
     * Setter du niveau d'attaque du personnage
     * @param levelAttack un entier
     * @return
     */
    public void setLevelAttack(int levelAttack) {
        //verify to avoid negative points
        if (levelAttack >= 0) {
            this.levelAttack = levelAttack;
        } else {
            this.levelAttack = 0;
        }
    }


    /**
     * Setter de l'équipement offensif du joueur
     * @param offensiveEquip objet de type OffensiveEquipment
     * @return
     */
    public void setOffensiveEquip(OffensiveEquipment offensiveEquip) {
        this.offensiveEquip = offensiveEquip;
    }


    //toString  méthode pour afficher les informations du personnages
    /**
     * Méthode toString qui affiche le personnage Character
     * @param
     * @return une chaine de character
     */
    @Override
    public String toString() {
        return String.format("Character [ Name: %s, LeveLife: %d, LevelAttack: %d, Offensive Equipment: %s]",
                name, levelLife, levelAttack, offensiveEquip);
    }


}
