package fr.campus.donjons_dragons.Character;

import fr.campus.donjons_dragons.Equipment.Defensiv.DefensiveEquipment;
import fr.campus.donjons_dragons.Equipment.Offensiv.OffensiveEquipment;

public abstract class Character {

    //Attributes
    //private String typeCharacter;  //type Character : Warrior or Wizard
    private String name;
    private int levelLife;
    private int levelAttack;
    private OffensiveEquipment offensiveEquip;
    private DefensiveEquipment defensiveEquip;
    private int position;
    private int id;

    //constructor

    /**
     * Constructeur de l'objet Character
     * @param name le nom du personnage, levelLife
     * @return une instance de Character
     */
    public Character(String name, int levelLife, int levelAttack, OffensiveEquipment offensiveEquip, DefensiveEquipment defensiveEquip, int position) {
        //this.typeCharacter = typeChar;
        this.name = name;
        this.levelLife = levelLife;
        this.levelAttack = levelAttack;
        this.offensiveEquip = offensiveEquip;
        this.defensiveEquip = defensiveEquip;
        this.position = position;
    }


    //Getters

    /**
     * Getter de l'identifiant du personnage
     * @return un entier
     */
    public int getId() {
        return id;
    }

    /**
     * Getter du nom du personnage
      * @return une chaine de character: le nom du personnage
     */
    public String getName() {
        return name;
    }

    /**
     * Getter de la position du joueur sur le plateau
     * @return un entier: la position actuelle du joueur
     */
    public int getPosition() {
        return position;
    }


    /**
     * Getter du niveau de vie du personnage
     * @return un entier: le niveau de vie du personnage
     */
    public int getLevelLife() {
        return levelLife;
    }

    /**
     * Getter du niveau d'attaque du personnage
     * @return un entier: le niveau d'attaque du personnage
     */
    public int getLevelAttack() {
        return levelAttack;
    }

    /**
     * Getter de l'équipement offensif du personnage
     * @return un objet de type OffensiveEquipment
     */
    public OffensiveEquipment getOffensiveEquip() {
        return offensiveEquip;
    }

    /**
     * Getter de l'équipement défensif du personnage
     * @return un objet de type defensiveEquipment
     */
    public DefensiveEquipment getDefensiveEquip() {
        return defensiveEquip;
    }

    //Setters
    /**
     * Setter de l'identifiant du personnage
     * @param id un entier
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter du nom du personnage
     * @param :name une chaine de caractère
     * @return
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter de la position du joueur sur le plateau
     * @param position un entier représentant la case où on place le joueur
     * @return
     */
    public void setPosition(int position) {
        this.position = position;
    }


    /**
     * Setter du niveau de vie du personnage
     * @param levelLife un entier
     * @return
     */
    public void setLevelLife(int levelLife) {
        //verify to avoid negative points
        if (levelLife >= 0) {
            this.levelLife = levelLife;
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

    /**
     * Setter de l'équipement défensif du joueur
     * @param defensiveEquip objet de type DefensiveEquipment
     * @return
     */
    public void setDefensiveEquip(DefensiveEquipment defensiveEquip) {
        this.defensiveEquip = defensiveEquip;
    }


    //toString  méthode pour afficher les informations du personnages
    /**
     * Méthode toString qui affiche le personnage Character
     * @return une chaine de character
     */
    @Override
    public String toString() {
        return String.format("Character [ Name: %s, LeveLife: %d, LevelAttack: %d, Offensive Equipment: %s, Defensive Equipment: %s, position; %d]",
                name, levelLife, levelAttack, offensiveEquip, defensiveEquip, position);
    }

}
