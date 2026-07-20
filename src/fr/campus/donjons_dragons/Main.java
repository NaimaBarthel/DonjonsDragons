import fr.campus.donjons_dragons.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    IO.println("Hello and welcome to Donjons & Dragons Game!");
    //Création des équipements
    OffensiveEquipment weap = new OffensiveEquipment("Weapon",7,"WeapAttack");
    OffensiveEquipment spel = new OffensiveEquipment("Spell",6, "SpelAttack");

    DefensiveEquipment shield = new DefensiveEquipment("Shield",9, "ShieldlDfsv");
    DefensiveEquipment potion = new DefensiveEquipment("Potion",8, "PotionDfsv");
    //Création des personnages
    /*Character warrior = new Character("Warrior","Bilbon",5, 3, weap);
    Character wizard = new Character("Wizard","Gandalf", 8, 10, spel);*/
    Warrior warrior = new Warrior("Bilbon",5, 3, weap);
    Wizard wizard = new Wizard("Gandalf", 8, 10, spel);


    System.out.println("-----New Warrior-----");
    System.out.println(warrior.toString());
    System.out.println("-----New Wizard-----");
    System.out.println(wizard.toString());
    System.out.println("--------New DefensiveEquipment--------");
    System.out.println(shield.toString());
    System.out.println("--------New DefensiveEquipment--------");
    System.out.println(potion.toString());
}
