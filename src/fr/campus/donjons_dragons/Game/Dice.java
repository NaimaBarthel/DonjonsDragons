package fr.campus.donjons_dragons.Game;

import java.util.Random;

public class Dice {
    //Attributes
    private final Random random = new Random();

    //Constructor
    public Dice() {
    }

    /**
     * méthode représentant le lancé du dé
     * @param pipe entier qui représente l'entier max que le dé peut lancer
     * @return un entier de 1 à 6
     */
    public int roll(int pipe) {
        return random.nextInt(pipe) + 1;
    }


}
