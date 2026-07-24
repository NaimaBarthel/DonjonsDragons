# 📚 Glossaire Java - Projet Donjons & Dragons

#java #syntaxe #donjons-dragons #programmation #glossaire

*Glossaire interactif des syntaxes Java utilisées dans le projet Donjons & Dragons*
*Généré le 24/07/2026*

---

## 🎯 Navigation
- [[#Structure de Base|Structure de Base]]
- [[#Classes et Objets|Classes et Objets]]
- [[#Héritage et Polymorphisme|Héritage et Polymorphisme]]
- [[#Modificateurs dAccès|Modificateurs d'Accès]]
- [[#Types de Données|Types de Données]]
- [[#Exemples Concrets|Exemples Concrets du Projet]]
- [[Fichiers du projet|Fichiers du projet]]

---

## 🏗️ Structure de Base

### Package
> [!NOTE] Déclare le package auquel appartient la classe

**Syntaxe :**
```java
package fr.campus.donjons_dragons;
```

**Fichiers concernés :** Tous les fichiers `.java` du projet

**Obsidian Link :** [[Character.java]], [[Game.java]], [[Warrior.java]], [[Wizard.java]]

---

### Import
> [!TIP] Utilisez des imports pour accéder à des classes externes

| **Type** | **Syntaxe** | **Exemple** | **Utilisation** |
|----------|-------------|-------------|-----------------|
| Import standard | `import package.Class;` | `import java.util.Scanner;` | Lecture utilisateur |
| Import standard | `import package.Class;` | `import java.util.Random;` | Génération aléatoire |
| Import statique | `import static...` | `import static fr.campus.donjons_dragons.Game.NUM_TYPE_PLAYER;` | Accès direct à une constante |

**Fichiers :** [[Game.java]], [[Dice.java]], [[Menu.java]]

---

## 📦 Classes et Objets

### Déclaration de Classe
> [!INFO] Une classe est un modèle pour créer des objets

#### Classe standard
```java
public class Character { }
```
**Fichier :** [[Character.java]]

#### Classe abstraite
```java
public abstract class Character { }
```
**Fichier :** [[Character.java]]

#### Record (Java 16+)
> [!IMPORTANT] Les records sont immutables par défaut

```java
public record Cell(int index) {
    public Cell { }
    
    @Override
    public int index() {
        return index;
    }
}
```
**Fichier :** [[Cell.java]]

---

### Instanciation
> [!EXAMPLE] Comment créer des objets

| **Type** | **Syntaxe** | **Exemple** | **Fichier** |
|----------|-------------|-------------|-------------|
| Objet simple | `new Class()` | `new Dice()` | [[Game.java:12]] |
| Avec paramètres | `new Class(p1, p2)` | `new Warrior(chosenName)` | [[Game.java:129]] |
| Tableau | `new Type[length]` | `new Cell[SIZE]` | [[Board.java:16]] |

---

## 🎯 Héritage et Polymorphisme

### Héritage
> [!DEFINITION] Permet à une classe d'hériter des attributs et méthodes d'une autre

**Arbre d'héritage du projet :**
```
Character (abstract)
├── Warrior
└── Wizard
```

**Syntaxe :**
```java
public class Warrior extends Character { }
public class Wizard extends Character { }
```
**Fichiers :** [[Warrior.java]], [[Wizard.java]]

---

### Appel au constructeur parent
> [!CAUTION] Toujours appeler super() en premier dans le constructeur

```java
public Warrior(String name) {
    super(name, 10, 5, null, 1);  // Appel au constructeur de Character
}
```
**Fichiers :** [[Warrior.java:8]], [[Wizard.java:7]]

---

### Accès aux membres parent
> [!TIP] Utilisez super. pour accéder aux membres de la classe parente

```java
super.getName()
super.getLevelLife()
super.getLevelAttack()
super.getOffensiveEquip()
super.getPosition()
```
**Fichiers :** [[Warrior.java]], [[Wizard.java]]

---

### Polymorphisme
> [!EXAMPLE] La même méthode peut avoir un comportement différent selon l'objet

**Exemple avec toString() :**
```java
// Dans Character.java
@Override
public String toString() {
    return String.format("Character [ Name: %s, LeveLife: %d, ...]", ...);
}

// Dans Warrior.java
@Override
public String toString() {
    return String.format("Warrior [ Type: %s, Name: %s, ...]", type, ...);
}
```

---

## 🔐 Modificateurs d'Accès

> [!SUMMARY] Tableau récapitulatif des modificateurs

| **Modificateur** | **Syntaxe** | **Exemple** | **Portée** | **Fichier** |
|-----------------|-------------|-------------|------------|-------------|
| public | `public class` | `public class Game` | Partout | [[Game.java:8]] |
| public | `public type` | `public int getLevelLife()` | Partout | [[Character.java:79]] |
| private | `private type` | `private String name` | Classe seulement | [[Character.java:7]] |
| protected | `protected type` | `protected final String type` | Package + sous-classes | [[Warrior.java:4]] |
| static | `static type` | `public static final int SIZE` | Classe, pas instance | [[Board.java:8]] |
| final | `final type` | `private final Menu menu` | Non modifiable | [[Game.java:11]] |
| abstract | `abstract class` | `public abstract class Character` | Ne peut pas être instanciée | [[Character.java:3]] |

---

### Combinaisons courantes

#### Constante publique
```java
public static final int NUM_TYPE_PLAYER = 2;
```
**Fichier :** [[Game.java:10]]

#### Variable finale privée
```java
private final Scanner scanner = new Scanner(System.in);
```
**Fichier :** [[Game.java:14]]

#### Singleton
```java
private static final Menu INSTANCE = new Menu();
```
**Fichier :** [[Menu.java:12]]

---

## 📊 Types de Données

### Types Primitifs
> [!LIST] Types primitifs utilisés dans le projet

- **`int`** : `private int levelLife;` ([[Character.java:8]])
- **`boolean`** : `private boolean running;` ([[Game.java:49]])

### Types Objet
> [!LIST] Types objet utilisés

| **Type** | **Exemple** | **Fichier** | **Utilisation** |
|----------|-------------|-------------|-----------------|
| String | `private String name;` | [[Character.java:7]] | Stockage de texte |
| Scanner | `private Scanner scanner;` | [[Game.java:14]], [[Menu.java:17]] | Lecture utilisateur |
| Random | `private Random random;` | [[Dice.java:7]] | Génération aléatoire |
| Character | `private Character player;` | [[Game.java:15]] | Personnage du jeu |
| OffensiveEquipment | `private OffensiveEquipment offensiveEquip;` | [[Character.java:10]] | Équipement offensif |
| DefensiveEquipment | Classe dédiée | [[DefensiveEquipment.java]] | Équipement défensif |
| Board | `private final Board board;` | [[Game.java:13]] | Plateau de jeu |
| Cell | `private final Cell[] cells;` | [[Board.java:9]] | Case du plateau |
| Dice | `private final Dice dice;` | [[Game.java:12]] | Dé du jeu |
| Menu | `private final Menu menu;` | [[Game.java:11]] | Interface utilisateur |

---

## 💾 Variables et Constantes

### Variables d'instance
```java
private String name;
private int levelLife;
private int levelAttack;
```
**Fichier :** [[Character.java]]

### Variables locales
```java
int roll = dice.roll();
```
**Fichier :** [[Game.java:74]]

### Variables finales
```java
private final Menu menu = Menu.getInstance();
private final Dice dice = new Dice();
private final Board board = new Board();
private final Scanner scanner = new Scanner(System.in);
```
**Fichier :** [[Game.java]]

### Constantes

#### Constante publique
```java
public static final int SIZE = 64;  // Taille du plateau
public static final int NUM_TYPE_PLAYER = 2;  // Nombre de types de joueurs
```
**Fichiers :** [[Board.java:8]], [[Game.java:10]]

---

## 🔄 Méthodes

> [!QUOTE] "Une méthode est un ensemble d'instructions qui effectue une tâche spécifique."

### Types de méthodes

| **Type** | **Syntaxe** | **Exemple** | **Fichier** |
|----------|-------------|-------------|-------------|
| Méthode void | `public void nom() {}` | `public void start()` | [[Game.java:48]] |
| Avec paramètres | `public void nom(ParamType p)` | `public void setName(String name)` | [[Character.java:49]] |
| Avec retour | `public Type nom() { return val; }` | `public int getLevelLife()` | [[Character.java:79]] |
| Constructeur | `public ClassName(Params) {}` | `public Character(...)` | [[Character.java:21]] |
| Statique | `public static Type nom() {}` | `public static Menu getInstance()` | [[Menu.java:31]] |
| Privée | `private void nom() {}` | `private void playTurn()` | [[Game.java:70]] |

---

### Annotations

| **Annotation** | **Exemple** | **Description** | **Fichier** |
|----------------|-------------|-----------------|-------------|
| `@Override` | `@Override public String toString()` | Indique une redéfinition | [[Character.java:154]], [[Warrior.java:13]], [[Cell.java:23]] |

---

### Méthode toString()
> [!BEST-PRACTICE] Toujours redéfinir toString() pour un affichage lisible

**Pattern utilisé :**
```java
@Override
public String toString() {
    return String.format("ClassName [ field1: %s, field2: %d, ...]", 
            field1, field2, ...);
}
```

**Fichiers :**
- [[Character.java:154]]
- [[Warrior.java:13]]
- [[Wizard.java:11]]
- [[OffensiveEquipment.java:96]]
- [[DefensiveEquipment.java:43]]

---

## ⚡ Structures de Contrôle

### Conditions

| **Structure** | **Syntaxe** | **Exemple** | **Fichier** |
|---------------|-------------|-------------|-------------|
| if | `if (condition) {}` | `if (chosenType.equals("1"))` | [[Game.java:128]] |
| if-else | `if (c) {} else {}` | `if (levelLife >= 0) {} else {}` | [[Character.java:93]] |
| else if | `else if (c) {}` | `else if (response.equalsIgnoreCase("n"))` | [[Menu.java:58]] |

---

### Boucles

| **Structure** | **Syntaxe** | **Exemple** | **Fichier** |
|---------------|-------------|-------------|-------------|
| while | `while (condition) {}` | `while (!board.isFinished(...))` | [[Game.java:94]] |
| do-while | `do {} while (c);` | `do { ... } while (!chosenType.matches(...))` | [[Game.java:111]] |
| for | `for (init; c; inc) {}` | `for (int i = 0; i < SIZE; i++)` | [[Board.java:17]] |

---

### Exemple de boucle for avec tableau
> [!EXAMPLE] Initialisation du plateau de jeu

```java
public Board() {
    cells = new Cell[SIZE];
    for (int i = 0; i < SIZE; i++) {
        cells[i] = new Cell(i + 1);
    }
}
```
**Fichier :** [[Board.java:15-20]]

---

## 📋 Tableaux

> [!DEFINITION] Structure de données qui stocke des éléments du même type

### Déclaration et Initialisation

**Phase 1 : Déclaration**
```java
private final Cell[] cells;  // Déclaration du tableau
```
**Fichier :** [[Board.java:9]]

**Phase 2 : Initialisation**
```java
cells = new Cell[SIZE];  // Création du tableau de taille SIZE
```
**Fichier :** [[Board.java:16]]

**Phase 3 : Peuplement**
```java
for (int i = 0; i < SIZE; i++) {
    cells[i] = new Cell(i + 1);  // Initialisation de chaque élément
}
```
**Fichier :** [[Board.java:17-19]]

---

## 🖥️ Entrées/Sorties

### Scanner
> [!WARNING] N'oubliez pas de fermer le Scanner (ou utilisez try-with-resources)

**Initialisation :**
```java
private final Scanner scanner = new Scanner(System.in);
```
**Fichiers :** [[Game.java:14]], [[Menu.java:17]]

**Méthodes utilisées :**
| **Méthode** | **Exemple** | **Description** | **Fichier** |
|-------------|-------------|-----------------|-------------|
| `nextLine()` | `scanner.nextLine()` | Lit une ligne complète | [[Game.java:72]], [[Menu.java:119]] |
| `nextInt()` | `scanner.nextInt()` | Lit un entier | [[Menu.java:99]] |
| `nextLine()` (nettoyage) | `scanner.nextLine()` | Nettoie le buffer après nextInt | [[Menu.java:101]] |

---

### System.out
> [!TIP] Pour l'affichage console

| **Méthode** | **Exemple** | **Fichier** |
|-------------|-------------|-------------|
| `println()` | `System.out.println("Welcome...");` | [[Menu.java:43]] |
| `print()` | `System.out.print("Lancé de dé = " + roll);` | [[Game.java:81]] |
| `printf()` | Non utilisé | - |

---

### System.exit()
> [!CAUTION] Termine immédiatement le programme

```java
if (messInput.equalsIgnoreCase("Q")) {
    System.exit(0);  // Quitte avec code 0 (succès)
}
```
**Fichier :** [[Menu.java:121]]

---

## 🔍 Expressions Régulières

> [!USAGE] Utilisées pour la validation des entrées utilisateur

### Méthode matches()

| **Pattern** | **Exemple** | **Description** | **Fichier** |
|-------------|-------------|-----------------|-------------|
| `"^[1-2]$"` | `!chosenType.matches("^[1-2]$")` | Vérifie si le choix est 1 ou 2 | [[Game.java:115]] |
| `"^[\\p{L}-]+$"` | `!chosenName.matches("^[\\p{L}-]+$")` | Vérifie si le nom contient seulement des lettres et tirets | [[Game.java:123]] |

**Explications :**
- `^` : Début de la chaîne
- `[1-2]` : Un caractère parmi 1 ou 2
- `$` : Fin de la chaîne
- `\p{L}` : Toute lettre (Unicode)
- `-` : Le caractère tiret
- `+` : Un ou plusieurs occurrences

---

## 🎯 Mécanismes Avancés

### Pattern Singleton
> [!PATTERN] Garantit qu'une classe n'a qu'une seule instance

**Implémentation complète dans [[Menu.java]] :**
```java
public class Menu {
    // 1. Instance unique (static et final)
    private static final Menu INSTANCE = new Menu();
    
    // 2. Scanner pour les entrées utilisateur
    private final Scanner scanner = new Scanner(System.in);
    
    // 3. Constructeur PRIVÉ pour empêcher l'instanciation externe
    private Menu() { }
    
    // 4. Méthode statique pour accéder à l'instance
    public static Menu getInstance() {
        return INSTANCE;
    }
    
    // ... autres méthodes
}
```

**Utilisation :**
```java
private final Menu menu = Menu.getInstance();  // [[Game.java:11]]
```

---

### Méthode equalsIgnoreCase()
> [!TIP] Comparaison de chaînes sans tenir compte de la casse

```java
if (response.equalsIgnoreCase("o")) {
    return true;
} else if (response.equalsIgnoreCase("n")) {
    return false;
}
```
**Fichiers :** [[Menu.java:56]], [[Menu.java:76]], [[Menu.java:138]]

---

### Classe Random
> [!EXAMPLE] Génération de nombres aléatoires

**Implémentation dans [[Dice.java]] :**
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
        return random.nextInt(6) + 1;  // 0-5 + 1 = 1-6
    }
}
```

**Explication :**
- `random.nextInt(6)` : Génère un entier entre 0 (inclus) et 6 (exclus)
- `+ 1` : Décale la plage pour obtenir 1-6

---

### String.format()
> [!BEST-PRACTICE] Formattage de chaînes avancé

**Pattern utilisé dans tous les toString() :**
```java
return String.format("ClassName [ field1: %s, field2: %d, field3: %s]", 
        value1, value2, value3);
```

**Spécificateurs de format :**
- `%s` : Chaîne de caractères
- `%d` : Entier décimal
- `%f` : Nombre à virgule (non utilisé dans ce projet)

**Fichiers :** Tous les fichiers avec toString()

---

## 💬 Commentaires et Documentation

### Commentaires en ligne
> [!NOTE] Pour des commentaires courts

```java
//Attributes
//constructor
//Getters
```
**Fichiers :** Tous les fichiers

---

### Commentaires multi-lignes
> [!NOTE] Pour des commentaires plus longs

```java
/*
 * Constructeur
 * où on initialise le jeu en lançant le menu
 */
```
**Fichier :** [[Game.java:17-20]]

---

### Javadoc
> [!IMPORTANT] Documentation standard de Java

**Structure complète :**
```java
/**
 * Description de la classe/méthode.
 * 
 * @param nom description du paramètre
 * @return description de la valeur de retour
 * @see AutresClasses si nécessaire
 */
```

**Balises utilisées dans le projet :**

| **Balise** | **Exemple** | **Description** | **Fichier** |
|------------|-------------|-----------------|-------------|
| `@param` | `@param name le nom du personnage` | Décrit un paramètre | [[Character.java:18]] |
| `@return` | `@return une instance de Character` | Décrit la valeur de retour | [[Character.java:19]] |
| `@link` | `@link #INSTANCE` | Crée un lien vers un autre élément | [[Menu.java:21]] |

---

## 📂 Fichiers du projet

> [!INDEX] Liste complète des fichiers analysés

### Fichiers Principaux

| **Fichier** | **Type** | **Description** | **Lignes** | **Rôle** |
|-------------|----------|-----------------|------------|----------|
| [[Character.java]] | Classe abstraite | Base pour tous les personnages | 161 | Modèle de personnage |
| [[Warrior.java]] | Classe concrète | Personnage de type Guerrier | 17 | Type de personnage |
| [[Wizard.java]] | Classe concrète | Personnage de type Magicien | 15 | Type de personnage |
| [[Game.java]] | Classe | Logique principale du jeu | 169 | Moteur du jeu |
| [[Dice.java]] | Classe | Gestion du dé | 23 | Génération aléatoire |
| [[Board.java]] | Classe | Plateau de jeu | 31 | Gestion du plateau |
| [[Cell.java]] | Record | Case du plateau | 29 | Structure de données |
| [[Menu.java]] | Classe | Interface utilisateur (Singleton) | 149 | Interaction utilisateur |
| [[Main.java]] | Classe | Point d'entrée | 11 | Démarrage du programme |
| [[OffensiveEquipment.java]] | Classe | Équipement offensif | 101 | Objets du jeu |
| [[DefensiveEquipment.java]] | Classe | Équipement défensif | 46 | Objets du jeu |

---

## 🎓 Concepts OOP Utilisés

> [!SUMMARY] Résumé des concepts de programmation orientée objet

### ✅ Encapsulation
- **Implémentation :** Tous les attributs sont `private`
- **Accès :** Via des getters et setters
- **Exemple :**
  ```java
  private String name;
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  ```

### ✅ Héritage
- **Hiérarchie :** `Character` (abstrait) → `Warrior`, `Wizard`
- **Avantage :** Réutilisation du code et spécialisation
- **Syntaxe :** `extends Character`

### ✅ Polymorphisme
- **Implémentation :** Redéfinition de `toString()` dans les sous-classes
- **Avantage :** Même méthode, comportement différent selon le type

### ✅ Abstraction
- **Implémentation :** Classe `Character` déclarée `abstract`
- **Avantage :** Ne peut pas être instanciée directement

### ✅ Singleton
- **Implémentation :** Classe `Menu` avec instance unique
- **Avantage :** Une seule instance partagée dans toute l'application

### ✅ Record
- **Implémentation :** `Cell` comme record
- **Avantage :** Code concis pour les classes de données immutables

### ✅ Composition
- **Implémentation :** `Game` contient `Menu`, `Dice`, `Board`, `Character`
- **Avantage :** Relation "a un" plutôt que "est un"

---

## 📊 Statistiques

### Compte des éléments
- **Classes concrètes :** 9
- **Classes abstraites :** 1
- **Records :** 1
- **Interfaces :** 0
- **Fichiers Java :** 11
- **Lignes de code (approx.) :** 900+

### Mots-clés les plus fréquents
1. `public` - Très fréquent
2. `private` - Très fréquent
3. `int` - Très fréquent
4. `String` - Très fréquent
5. `void` - Très fréquent
6. `return` - Fréquent
7. `if` - Fréquent
8. `this` - Fréquent
9. `new` - Fréquent
10. `super` - Modérément fréquent

---

## 🔗 Liens Externes
- [Documentation Oracle Java](https://docs.oracle.com/en/java/)
- [Java Tutorials](https://docs.oracle.com/javase/tutorial/)
- [Java 16 Records](https://openjdk.java.net/jeps/395)
- [Singleton Pattern](https://refactoring.guru/fr/design-patterns/singleton)

---

## 📝 Notes Personnelles

> [!TODO] À ajouter ou vérifier
- [ ] Vérifier si d'autres patterns sont utilisés
- [ ] Documenter les futures extensions
- [ ] Ajouter des exemples d'utilisation

> [!IDEA] Idées pour amélioration
- Implémenter des interfaces pour les équipements
- Ajouter plus de types de personnages
- Utiliser des énumérations pour les types d'équipements

---

*Ce glossaire est conçu pour être utilisé avec Obsidian. Utilisez les liens internes pour naviguer entre les sections.*
*Tags : #java #syntaxe #donjons-dragons #programmation #glossaire #obsidian*
