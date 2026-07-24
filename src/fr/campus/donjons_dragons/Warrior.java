package fr.campus.donjons_dragons;

public class Warrior extends Character {
    protected final String type = "WARRIOR";

    public Warrior(String name) {
        //super(name,leveLife,levelAttack,offensiveEquip);
        super(name, 10, 5, null, 1);
        // this.type = typeChar;
    }

    //toString  méthode pour afficher les informations du personnages
    public String toString() {
        return String.format("Warrior [ Type: %s, Name: %s, LeveLife: %d, LevelAttack: %d, Offensive Equipment: %s, position: %d]", type,
                super.getName(), super.getLevelLife(), super.getLevelAttack(), super.getOffensiveEquip(), super.getPosition());
    }
}
