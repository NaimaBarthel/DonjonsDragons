package fr.campus.donjons_dragons;

public class OffensiveEquipment {
    //Attributs
    private String type;  //"Weapon"  or  "Spell"
    private int attackLevel;  //Level of Attack
    private String name;

    //Constructeur
    public OffensiveEquipment(String offensiveEquipTyp,int attackLevel, String name){
        this.type = offensiveEquipTyp;
        this.attackLevel = attackLevel;
        this.name = name;
    }

    //Getter
    public String getType(){
        return type;
    }

    public int getAttackLevel(){
        return attackLevel;
    }

    public String getName(){
        return name;
    }

    //Setters
    public void setType(String offensiveEquip){
        this.type = offensiveEquip;
    }
    public void setAttackLevel(int attackLevel){
        this.attackLevel = attackLevel;
    }
    public void setName(String name){
        this.name = name;
    }


    //toString  méthode pour afficher les informations de l'équipememnt d'attaque
    @Override
    public String toString(){
        return String.format("Offensive Equipment [ Type: %s, Offensive Level: %d, Name: %s]",type,attackLevel,name);
    }


}
