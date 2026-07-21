package fr.campus.donjons_dragons;

public class Main {
    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    public static void main() {
        Menu menu = new Menu();

        menu.intro();
        int chosenType = menu.askPlayerInt("Choisissez le type de personnage:\n1. Warrior\n2. Wizard\n>");
        System.out.println(chosenType);
        String chosenName = menu.askPlayerName("Choisissez le nom de votre personnage:\n>");
        System.out.println(chosenName);

        Character monPersonnage;
        if (chosenType == 1) {
            monPersonnage = new Warrior(chosenName, 10, 5, new OffensiveEquipment("none", 0, "none"));
        } else //(chosenType == 2)
        {
            monPersonnage = new Wizard(chosenName, 7, 7, new OffensiveEquipment("none", 0, "none"));
        }

        System.out.println("Mon Personnage: " + monPersonnage.toString());





    /*
    //Création des équipements
    OffensiveEquipment weap = new OffensiveEquipment("Weapon",7,"WeapAttack");
    OffensiveEquipment spel = new OffensiveEquipment("Spell",6, "SpelAttack");

    DefensiveEquipment shield = new DefensiveEquipment("Shield",9, "ShieldlDfsv");
    DefensiveEquipment potion = new DefensiveEquipment("Potion",8, "PotionDfsv");
    //Création des personnages

    Warrior warrior = new Warrior("Bilbon",5, 3, weap);
    Wizard wizard = new Wizard("Gandalf", 8, 10, spel);


    System.out.println("-----New Warrior-----");
    System.out.println(warrior);
    System.out.println("-----New Wizard-----");
    System.out.println(wizard);
    System.out.println("--------New DefensiveEquipment--------");
    System.out.println(shield.toString());
    System.out.println("--------New DefensiveEquipment--------");
    System.out.println(potion.toString());*/

    }
}