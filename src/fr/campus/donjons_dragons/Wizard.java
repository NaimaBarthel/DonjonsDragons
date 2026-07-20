package fr.campus.donjons_dragons;

public class Wizard extends Character{
    private static final String type = "WIZARD";

    public Wizard(String name, int leveLife, int levelAttack, OffensiveEquipment offensiveEquip) {
        super(name,leveLife,levelAttack,offensiveEquip);
    }
}
