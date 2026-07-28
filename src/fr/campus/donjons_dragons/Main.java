package fr.campus.donjons_dragons;

import db.Database;
import fr.campus.donjons_dragons.Game.Game;

public class Main {
    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    static void main() {
        Database db = new Database();
        db.connect();
        db.getCharacters();
        db.close();
        Game game = new Game();
        //on lance le jeu
        game.start();
    }

}