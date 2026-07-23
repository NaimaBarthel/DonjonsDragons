package fr.campus.donjons_dragons;

public class Warrior extends Character {
    protected final String type = "WARRIOR";

    public Warrior(String name) {
        //super(name,leveLife,levelAttack,offensiveEquip);
        super(name, 10, 5, null);
        // this.type = typeChar;
    }

    //toString  méthode pour afficher les informations du personnages
    public String toString() {
        return String.format("Wizard [ Name: %s, LeveLife: %d, LevelAttack: %d, Offensive Equipment: %s]",
                super.getName(), super.getLevelLife(), super.getLevelAttack(), super.getOffensiveEquip());
    }
}
