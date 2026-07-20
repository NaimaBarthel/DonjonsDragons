package fr.campus.donjons_dragons;

public class DefensiveEquipment {
    //Attributs
    private String type;  //"Shield" or "Potion"
    private int defenseLevel;   // Level of defense
    private String name;    //nom de l'équipement
    //Constructeur
    public DefensiveEquipment(String defensiveEquipTyp, int defenseLevel, String name){
        this.type = defensiveEquipTyp;
        this.defenseLevel = defenseLevel;
        this.name = name;
    }

    //Getter
    public String getType(){
        return type;
    }

    public int getDefenseLevel(){
        return defenseLevel;
    }

    public String getName(){
        return name;
    }


    //Setter
    public void setType(String defensiveEquip){
        this.type = defensiveEquip;
    }

    public void setDefenseLevel(int defenseLevel){
        this.defenseLevel = defenseLevel;
    }

    public void setName(String name){
        this.name = name;
    }
    //toString méthode pour afficher les informations de l'équipement de défense
    public String toString(){
        return String.format("Defensive Equipment [ Type: %s, Defense Level: %d, Name: %s]",type,defenseLevel,name);
    }
}
