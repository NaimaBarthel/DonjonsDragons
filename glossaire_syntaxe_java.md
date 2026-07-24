# 📚 Glossaire des Syntaxes Java Utilisées dans le Projet Donjons & Dragons

*Généré automatiquement à partir des fichiers sources du projet*
*Dernière mise à jour : 24/07/2026*

---

## 📌 Table des Matières
1. [Structure de Base](#-structure-de-base)
2. [Classes et Objets](#-classes-et-objets)
3. [Héritage et Polymorphisme](#-héritage-et-polymorphisme)
4. [Modificateurs d'Accès](#-modificateurs-daccès)
5. [Types de Données](#-types-de-données)
6. [Variables et Constantes](#-variables-et-constantes)
7. [Méthodes](#-méthodes)
8. [Structures de Contrôle](#-structures-de-contrôle)
9. [Tableaux](#-tableaux)
10. [Entrées/Sorties](#-entrées-sorties)
11. [Expressions Régulières](#-expressions-régulières)
12. [Gestion des Erreurs](#-gestion-des-erreurs)
13. [Mécanismes Avancés](#-mécanismes-avancés)
14. [Commentaires et Documentation](#-commentaires-et-documentation)
15. [Exemples Concrets du Projet](#-exemples-concrets-du-projet)

---

## 🏗️ Structure de Base

### Package
Déclare le package auquel appartient la classe.

**Syntaxe utilisé dans le projet :**
```java
package fr.campus.donjons_dragons;
```

**Fichiers concernés :** Tous les fichiers `.java`

---

### Import
Permet d'importer des classes externes.

| **Syntaxe** | **Exemple dans le projet** | **Description** |
|-------------|----------------------------|-----------------|
| `import package.Class;` | `import java.util.Scanner;` | Import simple |
| `import java.util.Random;` | `import java.util.Random;` | Import de Random |
| `import static...` | `import static fr.campus.donjons_dragons.Game.NUM_TYPE_PLAYER;` | Import statique |

---

## 📦 Classes et Objets

### Déclaration de Classe

| **Syntaxe** | **Exemple dans le projet** | **Fichier** |
|-------------|----------------------------|-------------|
| `public class Nom {}` | `public class Character {}` | Character.java |
| `public abstract class Nom {}` | `public abstract class Character {}` | Character.java |

### Record (Java 16+)
Structure immutable pour transporter des données.

**Exemple dans Board.java :**
```java
public record Cell(int index) {
    public Cell { }
    
    @Override
    public int index() {
        return index;
    }
}
```

---

### Instanciation

| **Syntaxe** | **Exemple dans le projet** |
|-------------|----------------------------|
| `new Class()` | `new Dice()` (Game.java:12) |
| `new Class(param1, param2)` | `new Warrior(chosenName)` (Game.java:129) |
| `new Type[length]` | `new Cell[SIZE]` (Board.java:16) |

---

## 🎯 Héritage et Polymorphisme

### Héritage (extends)

**Syntaxe utilisé :**
```java
public class Warrior extends Character { ... }
public class Wizard extends Character { ... }
```

**Fichiers :** Warrior.java, Wizard.java

### Appel au constructeur parent

**Syntaxe utilisé :**
```java
super(name, 10, 5, null, 1);  // Warrior.java:8
super(name, 7, 7, null, 1);   // Wizard.java:7
```

### Accès aux membres parent

**Syntaxe utilisé :**
```java
super.getName()
super.getLevelLife()
super.getLevelAttack()
super.getOffensiveEquip()
super.getPosition()
```
**Fichiers :** Warrior.java, Wizard.java

---

## 🔐 Modificateurs d'Accès

| **Modificateur** | **Syntaxe** | **Exemple dans le projet** | **Description** |
|-----------------|-------------|----------------------------|-----------------|
| `public` | `public class` | `public class Game` | Accessible partout |
| `private` | `private type` | `private String name` (Character.java:7) | Accessible seulement dans la classe |
| `protected` | `protected type` | `protected final String type` (Warrior.java:4) | Accessible dans le package et les sous-classes |
| `static` | `static type` | `public static final int SIZE` (Board.java:8) | Appartient à la classe, pas à l'instance |
| `final` | `final type` | `private final Menu menu` (Game.java:11) | Ne peut pas être modifié après initialisation |
| `abstract` | `abstract class` | `public abstract class Character` | Classe qui ne peut pas être instanciée directement |

### Combinaisons courantes

```java
public static final int NUM_TYPE_PLAYER = 2;  // Constante publique
private final Scanner scanner = new Scanner(System.in);  // Variable finale privée
private static final Menu INSTANCE = new Menu();  // Singleton
```

---

## 📊 Types de Données

### Types Primitifs

| **Type** | **Exemple dans le projet** | **Fichier** |
|----------|----------------------------|-------------|
| `int` | `private int levelLife;` | Character.java |
| `boolean` | `private boolean running;` | Game.java |

### Types Objet

| **Type** | **Exemple dans le projet** | **Fichier** |
|----------|----------------------------|-------------|
| `String` | `private String name;` | Character.java |
| `Scanner` | `private Scanner scanner;` | Game.java, Menu.java |
| `Random` | `private Random random;` | Dice.java |
| Classes personnalisées | `Character`, `OffensiveEquipment`, `DefensiveEquipment`, `Board`, `Cell`, `Dice`, `Menu` | Tous |

---

## 💾 Variables et Constantes

### Déclaration de variables

```java
// Variable d'instance
private String name;
private int levelLife;

// Variable locale
int roll = dice.roll();  // Game.java:74

// Variable finale
private final Menu menu = Menu.getInstance();  // Game.java:11
```

### Constantes

```java
// Constante publique
public static final int SIZE = 64;  // Board.java:8
public static final int NUM_TYPE_PLAYER = 2;  // Game.java:10

// Constante privée
private final Scanner scanner = new Scanner(System.in);  // Game.java:14
```

---

## 🔄 Méthodes

### Déclaration de Méthode

| **Type** | **Syntaxe** | **Exemple dans le projet** |
|----------|-------------|----------------------------|
| Méthode simple | `public void nom() {}` | `public void start()` (Game.java:48) |
| Méthode avec paramètres | `public void nom(ParamType param) {}` | `public void setName(String name)` (Character.java:49) |
| Méthode avec retour | `public Type nom() { return value; }` | `public int getLevelLife()` (Character.java:79) |
| Constructeur | `public ClassName(ParamType param) {}` | `public Character(String name, ...)` (Character.java:21) |
| Méthode statique | `public static Type nom() {}` | `public static Menu getInstance()` (Menu.java:31) |
| Méthode privée | `private void nom() {}` | `private void playTurn()` (Game.java:70) |

### Annotations

| **Annotation** | **Exemple dans le projet** | **Description** |
|----------------|----------------------------|-----------------|
| `@Override` | `@Override public String toString()` | Indique qu'une méthode est redéfinie |

### Méthodes spécialisées

**toString() :**
```java
@Override
public String toString() {
    return String.format("Character [ Name: %s, LeveLife: %d, ...]", 
            name, levelLife, ...);
}
```
**Fichiers :** Character.java, Warrior.java, Wizard.java, OffensiveEquipment.java, DefensiveEquipment.java

---

## ⚡ Structures de Contrôle

### Conditions

| **Structure** | **Syntaxe** | **Exemple dans le projet** |
|---------------|-------------|----------------------------|
| `if` | `if (condition) {}` | `if (chosenType.equals("1"))` (Game.java:128) |
| `if-else` | `if (condition) {} else {}` | `if (levelLife >= 0) {} else {}` (Character.java:93) |
| `else if` | `else if (condition) {}` | `else if (response.equalsIgnoreCase("n"))` (Menu.java:58) |

### Boucles

| **Structure** | **Syntaxe** | **Exemple dans le projet** |
|---------------|-------------|----------------------------|
| `while` | `while (condition) {}` | `while (!board.isFinished(player.getPosition()))` (Game.java:94) |
| `do-while` | `do {} while (condition);` | `do { chosenType = ... } while (!chosenType.matches("^[1-2]$"));` (Game.java:111) |
| `for` | `for (init; condition; increment) {}` | `for (int i = 0; i < SIZE; i++)` (Board.java:17) |

---

## 📋 Tableaux

### Déclaration et Initialisation

```java
// Déclaration
private final Cell[] cells;  // Board.java:9

// Initialisation
cells = new Cell[SIZE];  // Board.java:16

// Initialisation des éléments
for (int i = 0; i < SIZE; i++) {
    cells[i] = new Cell(i + 1);  // Board.java:18
}
```

---

## 🖥️ Entrées/Sorties

### Scanner

```java
// Initialisation
private final Scanner scanner = new Scanner(System.in);  // Game.java:14

// Méthodes utilisées
scanner.nextLine();   // Attend une ligne (Game.java:72)
scanner.nextInt();    // Lit un entier (Menu.java:99)
```

### System.out

| **Méthode** | **Exemple dans le projet** |
|-------------|----------------------------|
| `System.out.println()` | `System.out.println("Welcome to Donjons & Dragons Game!");` (Menu.java:43) |
| `System.out.print()` | `System.out.print("Lancé de dé = " + roll + ".");` (Game.java:81) |
| `System.exit()` | `System.exit(0);` (Menu.java:121) |

---

## 🔍 Expressions Régulières

### Méthode matches()

| **Pattern** | **Exemple dans le projet** | **Description** |
|-------------|----------------------------|-----------------|
| `"^[1-2]$"` | `!chosenType.matches("^[1-2]$")` (Game.java:115) | Vérifie si le choix est 1 ou 2 |
| `"^[\\p{L}-]+$"` | `!chosenName.matches("^[\\p{L}-]+$")` (Game.java:123) | Vérifie si le nom contient seulement des lettres et des tirets |

---

## ⚠️ Gestion des Erreurs

### System.exit()

```java
if (messInput.equalsIgnoreCase("Q")) {
    System.exit(0);  // Menu.java:121
}
```

---

## 🎯 Mécanismes Avancés

### Pattern Singleton

**Implémentation dans Menu.java :**
```java
private static final Menu INSTANCE = new Menu();

private Menu() { }  // Constructeur privé

public static Menu getInstance() {
    return INSTANCE;
}
```

### Méthode equalsIgnoreCase()

```java
if (response.equalsIgnoreCase("o")) {  // Menu.java:56, 76, 138
    return true;
}
```

### Random

```java
private final Random random = new Random();  // Dice.java:7

public int roll() {
    return random.nextInt(6) + 1;  // Génère un nombre entre 1 et 6
}
```

### String.format()

```java
return String.format("Character [ Name: %s, LeveLife: %d, LevelAttack: %d, ...]", 
        name, levelLife, levelAttack, ...);  // Character.java:156
```

---

## 💬 Commentaires et Documentation

### Commentaires en ligne

```java
//Attributes
//constructor
//Getters
```

### Commentaires multi-lignes

```java
/*
 * Constructeur
 * où on initialise le jeu en lançant le menu
 */
```

### Javadoc

```java
/**
 * Constructeur de l'objet Character
 *
 * @param name le nom du personnage, levelLife
 * @return une instance de Character
 */
```

### Balises Javadoc utilisées

| **Balise** | **Exemple** | **Description** |
|------------|-------------|-----------------|
| `@param` | `@param name le nom du personnage` | Décrit un paramètre |
| `@return` | `@return une instance de Character` | Décrit la valeur de retour |
| `@link` | `@link #INSTANCE` | Crée un lien vers un autre élément |

---

## 📂 Exemples Concrets du Projet

### Exemple 1 : Classe Abstraite (Character.java)

```java
public abstract class Character {
    // Attributes
    private String name;
    private int levelLife;
    private int levelAttack;
    
    // Constructor
    public Character(String name, int levelLife, int levelAttack, 
                     OffensiveEquipment offensiveEquip, int position) {
        this.name = name;
        this.levelLife = levelLife;
        this.levelAttack = levelAttack;
        this.offensiveEquip = offensiveEquip;
        this.position = position;
    }
    
    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    // toString
    @Override
    public String toString() {
        return String.format("Character [ Name: %s, LeveLife: %d, ...]", 
                name, levelLife, ...);
    }
}
```

### Exemple 2 : Héritage (Warrior.java)

```java
public class Warrior extends Character {
    protected final String type = "WARRIOR";
    
    public Warrior(String name) {
        super(name, 10, 5, null, 1);
    }
    
    @Override
    public String toString() {
        return String.format("Warrior [ Type: %s, Name: %s, ...]", 
                type, super.getName(), super.getLevelLife(), ...);
    }
}
```

### Exemple 3 : Singleton (Menu.java)

```java
public class Menu {
    private static final Menu INSTANCE = new Menu();
    private final Scanner scanner = new Scanner(System.in);
    
    private Menu() { }  // Constructeur privé
    
    public static Menu getInstance() {
        return INSTANCE;
    }
    
    public void intro() {
        System.out.println("Welcome to Donjons & Dragons Game!");
    }
    
    public boolean askToStartAGame() {
        while (true) {
            String response = askPlayerString("Voulez-vous démarrer une partie? O/N ");
            if (response.equalsIgnoreCase("o")) {
                return true;
            } else if (response.equalsIgnoreCase("n")) {
                return false;
            }
        }
    }
}
```

### Exemple 4 : Utilisation de Random (Dice.java)

```java
import java.util.Random;

public class Dice {
    private final Random random = new Random();
    
    public Dice() { }
    
    /**
     * Méthode représentant le lancé du dé
     * @return un entier de 1 à 6
     */
    public int roll() {
        return random.nextInt(6) + 1;
    }
}
```

### Exemple 5 : Record (Cell.java)

```java
/**
 * Classe Cell représente une case du plateau
 */
public record Cell(int index) {
    /**
     * Constructeur d'une cellule
     */
    public Cell { }
    
    @Override
    public int index() {
        return index;
    }
}
```

### Exemple 6 : Boucle for et initialisation de tableau (Board.java)

```java
public class Board {
    public static final int SIZE = 64;
    private final Cell[] cells;
    
    public Board() {
        cells = new Cell[SIZE];
        for (int i = 0; i < SIZE; i++) {
            cells[i] = new Cell(i + 1);
        }
    }
    
    public boolean isFinished(int position) {
        return position >= SIZE;
    }
}
```

### Exemple 7 : Gestion de l'entrée utilisateur (Game.java)

```java
private void createPlayer() {
    String chosenType = "";
    do {
        chosenType = menu.askPlayerString("Choisissez le type de personnage:\n1. Warrior\n2. Wizard\n>");
        System.out.println(chosenType);
    } while (!chosenType.matches("^[1-2]$"));
    
    String chosenName = "";
    do {
        chosenName = menu.askPlayerString("Saisissez le nom de votre personnage:\n>");
        System.out.println(chosenName);
    } while (!chosenName.matches("^[\\p{L}-]+$"));
    
    if (chosenType.equals("1")) {
        player = new Warrior(chosenName);
    } else {
        player = new Wizard(chosenName);
    }
}
```

---

## 📊 Statistiques du Projet

### Nombre de fichiers par type
- **Classes concrètes :** 8 (Game, Dice, Warrior, Wizard, Board, Menu, OffensiveEquipment, DefensiveEquipment, Main)
- **Classes abstraites :** 1 (Character)
- **Records :** 1 (Cell)

### Mots-clés Java utilisés

| **Catégorie** | **Mots-clés** | **Occurrences** |
|--------------|---------------|-----------------|
| **Accès** | public, private, protected | Très fréquent |
| **Modificateurs** | static, final, abstract | Fréquent |
| **Types** | int, boolean, String | Très fréquent |
| **Contrôle** | if, else, while, do, for | Fréquent |
| **Objet** | new, this, super | Fréquent |
| **Méthode** | return, void | Très fréquent |
| **Import** | import, static | Présent |
| **Package** | package | Présent dans tous les fichiers |

---

## 🔍 Index des Fichiers Analysés

| **Fichier** | **Description** | **Lignes** |
|-------------|-----------------|------------|
| Character.java | Classe abstraite de base pour les personnages | 161 |
| Warrior.java | Classe concrète pour le guerrier | 17 |
| Wizard.java | Classe concrète pour le magicien | 15 |
| Game.java | Classe principale du jeu | 169 |
| Dice.java | Classe pour gérer le dé | 23 |
| Board.java | Classe pour le plateau de jeu | 31 |
| Cell.java | Record pour une case du plateau | 29 |
| Menu.java | Classe Singleton pour l'interface utilisateur | 149 |
| Main.java | Point d'entrée du programme | 11 |
| OffensiveEquipment.java | Classe pour l'équipement offensif | 101 |
| DefensiveEquipment.java | Classe pour l'équipement défensif | 46 |

---

## 🎓 Résumé des Concepts OOP Utilisés

1. **Encapsulation** ✅
   - Tous les attributs sont privés
   - Accès via getters/setters

2. **Héritage** ✅
   - `Character` (abstrait) → `Warrior`, `Wizard`

3. **Polymorphisme** ✅
   - Méthode `toString()` redéfinie dans les sous-classes

4. **Abstraction** ✅
   - Classe abstraite `Character`
   - Méthodes abstraites (aucune dans ce projet, mais la classe est abstraite)

5. **Singleton** ✅
   - Pattern Singleton pour la classe `Menu`

6. **Record** ✅
   - Utilisation de `record` pour `Cell` (Java 16+)

7. **Composition** ✅
   - `Game` contient `Menu`, `Dice`, `Board`, `Character`
   - `Character` contient `OffensiveEquipment`

---

*Ce glossaire a été généré automatiquement à partir de l'analyse des fichiers Java du projet Donjons & Dragons.*
