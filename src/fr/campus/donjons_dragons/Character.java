package fr.campus.donjons_dragons;

public class Character {

    //Attributs
   //private String typeCharacter;  //type Character : Warrior or Wizard
   private String name;
   private int levelLife;
   private int levelAttack;
   private OffensiveEquipment offensiveEquip;

   //constructeurs
   //public Character(String typeChar, String name, int leveLife, int levelAttack, OffensiveEquipment offensiveEquip){
   public Character( String name, int leveLife, int levelAttack, OffensiveEquipment offensiveEquip){
       //this.typeCharacter = typeChar;
       this.name = name;
       this.levelLife = leveLife;
       this.levelAttack = levelAttack;
       this.offensiveEquip = offensiveEquip;
   }

   //Getters
   /*public String getTypeCharacter(){
       return typeCharacter;
   }*/

   public String getName(){
       return name;
   }

   public int getLevelLife(){
       return levelLife;
   }

   public int getLevelAttack(){
       return levelAttack;
   }

   public OffensiveEquipment getOffensiveEquip(){
       return offensiveEquip;
   }


   //Setters
   /*public void setTypeCharacter(String typeChar){
       this.typeCharacter = typeChar;
   }*/

   public void setName(String name){
       this.name = name;
   }

   public void setLevelLife(int leveLife){
       this.levelLife = leveLife;
   }

   public void setLevelAttack(int levelAttack){
       this.levelAttack = levelAttack;
   }

   public void setOffensivEquip(OffensiveEquipment offensiveEquip){
       this.offensiveEquip = offensiveEquip;
   }


    //toString  méthode pour afficher les informations du personnages
    @Override
    public String toString(){
       //return String.format("Character [ Type: %s, Name: %s, LeveLife: %d, LevelAttack: %d, Offensive Equipment: %s]",
        return String.format("Character [ Name: %s, LeveLife: %d, LevelAttack: %d, Offensive Equipment: %s]",
                name, levelLife,levelAttack,offensiveEquip);
    }


}
