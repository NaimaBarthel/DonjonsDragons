package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @ClassName Database
 * @Description Gère la connexion à la base de données MySQL ainsi que
 *               les requêtes permettant de récupérer les personnages du jeu.
 * @Author Naima Barthel
 * @Date 28/07/2026 14:47
 * @Version 1.0
 */
public class Database {
    //URL de connexion à la base de données.
    private static final String URL = "jdbc:mysql://localhost:3306/db_donjons_et_dragons";
    //Nom de l'utilisateur utilisé pour la connexion
    private static final String USER = "javauser";
    //Mot de passe de l'utilisateur
    private static final String PASSWORD = "9Drag8&7Donj6!";
    //Connection active à la base de données
    private Connection connection;

    /**
     * Méthode qui permet d'établir une connexion avec la base de données MySQL.
     * Affiche un message de confirmation si la connexion est réussie,
     * sinon affiche l'erreur rencontrée.
     */
    public void connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie !");
        } catch (Exception e) {
            System.out.println("Erreur de connexion");
            e.printStackTrace();
        }
    }

    /**
     *  Méthode qui permet d'exécuter une requête SQL permettant de récupérer tous les
     *  personnages enregistrés dans la base de données.
     *  Les informations de chaque personnage sont affichées dans la console.
     */
    public void getCharacters() {

        try {

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM game_character");

            while (result.next()) {

                System.out.println("ID : " + result.getInt("id"));
                System.out.println("Nom : " + result.getString("name"));
                System.out.println("Type : " + result.getString("type"));
                System.out.println("Vie : " + result.getInt("lifePoints"));
                System.out.println("Force : " + result.getInt("strength"));
                System.out.println("----------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode qui permet de fermer la connexion à la base de données si celle-ci est ouverte.
     */
    public void close() {
        try {
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}