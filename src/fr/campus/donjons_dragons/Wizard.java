package fr.campus.donjons_dragons;

public class Wizard extends Character {
    protected final String type = "WIZARD";

    public Wizard(String name) {
        super(name, 7, 7, null);
    }

    //toString  méthode pour afficher les informations du personnages
    public String toString() {
        return String.format("Wizard [ Name: %s, LeveLife: %d, LevelAttack: %d, Offensive Equipment: %s]",
                super.getName(), super.getLevelLife(), super.getLevelAttack(), super.getOffensiveEquip());
    }
}
