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
     *
     * @return un entier de 1 à 6
     */
    public int roll() {
        return random.nextInt(6) + 1;
    }


}
