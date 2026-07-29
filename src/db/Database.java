package db;

import java.sql.*;

import fr.campus.donjons_dragons.Character.Character;
import fr.campus.donjons_dragons.Character.Warrior;

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
            // Création d'un objet Statement permettant d'exécuter des requêtes SQL
            Statement statement = connection.createStatement();
            // Exécute la requête SQL et stocke le résultat dans un objet ResultSet
            ResultSet result = statement.executeQuery("SELECT * FROM game_character");

            while (result.next()) {  //Tant qu'il y a des lignes à lire

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
     *  Méthode qui permet d'afficher la liste de tous les personnages
     *
     */
    public void getHeroes(){
        try {
            // Création d'un objet Statement permettant d'exécuter des requêtes SQL
            Statement statement = connection.createStatement();
            // Exécute la requête SQL et stocke le résultat dans un objet ResultSet
            ResultSet result = statement.executeQuery("SELECT * FROM game_character");
            System.out.println("=========== Liste des héros ===========");
            while (result.next()) {  //Tant qu'il y a des lignes à lire

                System.out.println(result.getInt("id") + " - "
                                    + result.getString("name")
                                    + " ( " + result.getString("type")
                                    + " )");

                System.out.println("Vie : " + result.getInt("lifePoints"));
                System.out.println("Force : " + result.getInt("strength"));
                System.out.println("Equip. d'attaque : " + result.getString("offensiveEquipment"));
                System.out.println("Equip. de  défense : " + result.getString("defensiveEquipment"));
                System.out.println("----------------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode qui permet d'insérer un personnage en base de données
     * @param Hero un objet de type Character à enregistrer dans la table game_character
     */
    public void createHero( Character hero){
        String sql = "INSERT INTO game_character "
                + "(type, name, lifePoints, strength, offensiveEquipment, defensiveEquipment) "
                + "VALUES (?,?,?,?,?,?)";

        try {
            // Création d'un objet PreparedStatement permettant de préparer la requête SQL
            //en remplaçant les paramètres (?) par les valeurs du héros
            PreparedStatement statement = connection.prepareStatement(sql);

            // Détermination du type du personnage
            //String type = hero instanceof Warrior ? "Warrior" : "Wizard";

            statement.setString(1, hero.getClass().getSimpleName());
            statement.setString(2, hero.getName());
            statement.setInt(3, hero.getLevelLife());
            statement.setInt(4, hero.getLevelAttack());

            if (hero.getOffensiveEquip() != null) {
                statement.setString(5, hero.getOffensiveEquip().getClass().getSimpleName());
            } else {
                statement.setNull(5, java.sql.Types.VARCHAR);
            }

            if (hero.getDefensiveEquip() != null) {
                statement.setString(6, hero.getDefensiveEquip().getClass().getSimpleName());
            } else {
                statement.setNull(6, java.sql.Types.VARCHAR);
            }


            statement.executeUpdate();

            System.out.println("Le héros a été enregistré avec succès.");

            statement.close();
       } catch (SQLException e){
            e.printStackTrace();
        }

    }

    /**
     * Méthode qui permet de modifier un personnage en base de données
     * @param Hero un objet de type Character à enregistrer dans la table game_character
     */
    public void editHero( Character hero){
        String sql = "UPDATE game_character "
                + "SET type = ?, "
                + "name = ?, "
                + "lifePoints = ?, "
                + "strength = ?, "
                + "offensiveEquipment = ?, "
                + "defensiveEquipment = ? "
                + "WHERE id = ?";

        try {
            // Création d'un objet PreparedStatement permettant de préparer la requête SQL
            //en remplaçant les paramètres (?) par les valeurs du héros
            PreparedStatement statement = connection.prepareStatement(sql);

            // Détermination du type du personnage
            //String type = hero instanceof Warrior ? "Warrior" : "Wizard";

            statement.setString(1, hero.getClass().getSimpleName());
            statement.setString(2, hero.getName());
            statement.setInt(3, hero.getLevelLife());
            statement.setInt(4, hero.getLevelAttack());

            if (hero.getOffensiveEquip() != null) {
                statement.setString(5, hero.getOffensiveEquip().getClass().getSimpleName());
            } else {
                statement.setNull(5, java.sql.Types.VARCHAR);
            }

            if (hero.getDefensiveEquip() != null) {
                statement.setString(6, hero.getDefensiveEquip().getClass().getSimpleName());
            } else {
                statement.setNull(6, java.sql.Types.VARCHAR);
            }

            statement.setInt(7, hero.getId());


            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Le héros a été modifié avec succès.");
            } else {
                System.out.println("Aucun héros trouvé avec l'id : " + hero.getId());
            }

            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void changeLifePoints(Character hero) {

        String sql = "UPDATE game_character SET lifePoints = ? WHERE id = ?";

        try {

            // Création d'un objet PreparedStatement permettant de préparer la requête SQL
            PreparedStatement statement = connection.prepareStatement(sql);

            // Mise à jour des points de vie du héros
            statement.setInt(1, hero.getLevelLife());

            // Identifiant du héros à modifier
            statement.setInt(2, hero.getId());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Les points de vie du héros ont été mis à jour.");
            } else {
                System.out.println("Aucun héros trouvé avec l'id : " + hero.getId());
            }

            statement.close();

        } catch (SQLException e) {
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