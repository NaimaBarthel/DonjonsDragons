package fr.campus.donjons_dragons;

public abstract class Character {

    //Attributes
   //private String typeCharacter;  //type Character : Warrior or Wizard
   private String name;
   private int levelLife;
   private int levelAttack;
   private OffensiveEquipment offensiveEquip;

   //constructors
   public Character( String name, int leveLife, int levelAttack, OffensiveEquipment offensiveEquip){
       //this.typeCharacter = typeChar;
       this.name = name;
       this.levelLife = leveLife;
       this.levelAttack = levelAttack;
       this.offensiveEquip = offensiveEquip;
   }


   //Getters
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
   public void setName(String name){
       this.name = name;
   }

   public void setLevelLife(int leveLife){
       //verify to avoid negative points
       if (leveLife >=0) {
           this.levelLife = leveLife;
       }
       else {
           this.levelLife = 0;  // if < 0, =0
       }
   }

   public void setLevelAttack(int levelAttack){
       this.levelAttack = levelAttack;
   }

   public void setOffensiveEquip(OffensiveEquipment offensiveEquip){
       this.offensiveEquip = offensiveEquip;
   }


    //toString  méthode pour afficher les informations du personnages
    @Override
    public String toString(){
        return String.format("Character [ Name: %s, LeveLife: %d, LevelAttack: %d, Offensive Equipment: %s]",
                name, levelLife,levelAttack,offensiveEquip);
    }

    //Méthode pour modifier le personnage
   /* public abstract void modifyAttributes(){

    }*/

}
