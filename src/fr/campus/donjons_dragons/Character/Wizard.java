package fr.campus.donjons_dragons.Character;

public class Wizard extends Character {
    protected final String type = "WIZARD";

    public Wizard(String name) {
        super(name, 7, 7, null, 1);
    }

    //toString  méthode pour afficher les informations du personnages
    public String toString() {
        return String.format("Wizard [ Type: %s, Name: %s, LeveLife: %d, LevelAttack: %d, Offensive Equipment: %s, position: %d]", type,
                super.getName(), super.getLevelLife(), super.getLevelAttack(), super.getOffensiveEquip(), super.getPosition());
    }
}
