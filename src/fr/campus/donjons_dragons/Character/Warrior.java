package fr.campus.donjons_dragons.Character;

public class Warrior extends Character {
    /////a supprimer
    protected final String type = "WARRIOR";

    public Warrior(String name) {
        //super(name,leveLife,levelAttack,offensiveEquip);
        super(name, 10, 5, null, null,1);
        // this.type = typeChar;
    }


}
