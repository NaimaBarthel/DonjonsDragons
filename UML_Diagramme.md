# Diagramme de Classe UML - Projet DonjonsDragons

Ce fichier contient les diagrammes de classe UML du projet DonjonsDragons au format **PlantUML** et **Mermaid**.

---

## 📊 Diagramme de Classe UML (Format PlantUML)

```plantuml
@startuml DonjonsDragons_UML

' ============== CLASSES PRINCIPALES ==============
abstract class Character {
  - name: String
  - levelLife: int
  - levelAttack: int
  - offensiveEquip: OffensiveEquipment
  + Character(name: String, leveLife: int, levelAttack: int, offensiveEquip: OffensiveEquipment)
  + getName(): String
  + getLevelLife(): int
  + getLevelAttack(): int
  + getOffensiveEquip(): OffensiveEquipment
  + setName(name: String): void
  + setLevelLife(leveLife: int): void
  + setLevelAttack(levelAttack: int): void
  + setOffensiveEquip(offensiveEquip: OffensiveEquipment): void
  + toString(): String
}

class Warrior {
  + type: String = "WARRIOR"
  + Warrior(name: String)
  + toString(): String
}

class Wizard {
  + type: String = "WIZARD"
  + Wizard(name: String)
  + toString(): String
}

class OffensiveEquipment {
  - type: String
  - attackLevel: int
  - name: String
  + OffensiveEquipment(offensiveEquipTyp: String, attackLevel: int, name: String)
  + getType(): String
  + getAttackLevel(): int
  + getName(): String
  + setType(offensiveEquip: String): void
  + setAttackLevel(attackLevel: int): void
  + setName(name: String): void
  + toString(): String
}

class DefensiveEquipment {
  - type: String
  - defenseLevel: int
  - name: String
  + DefensiveEquipment(defensiveEquipTyp: String, defenseLevel: int, name: String)
  + getType(): String
  + getDefenseLevel(): int
  + getName(): String
  + setType(defensiveEquip: String): void
  + setDefenseLevel(defenseLevel: int): void
  + setName(name: String): void
  + toString(): String
}

' ============== CLASSES DE GESTION ==============
class Game {
  + NUM_TYPE_PLAYER: int = 2
  - player: Character
  - menu: Menu
  + Game()
  + getPlayer(): Character
  + start(): void
  + createPlayer(): void
  + displayPlayer(): void
  + modifyPlayer(): void
}

class Menu {
  - INSTANCE: Menu (Singleton)
  - scanner: Scanner
  - Menu() [private]
  + getInstance(): Menu
  + intro(): void
  + askPlayerTypeInt(message: String): int
  + askPlayerString(message: String): String
  + askModifyCharacter(): boolean
}

class Main {
  + main(): void
}

' ============== RELATIONS ==============
Character <|-- Warrior
Character <|-- Wizard
Character "1" o-- "1" OffensiveEquipment
Game "1" o-- "1" Character
Game "1" --> "1" Menu

@enduml
```

---

## 📊 Diagramme de Classe UML (Format Mermaid)

```mermaid
classDiagram
    %% ============== CLASSES PRINCIPALES ==============
    class Character {
        <<abstract>>
        -String name
        -int levelLife
        -int levelAttack
        -OffensiveEquipment offensiveEquip
        +Character(String, int, int, OffensiveEquipment)
        +getName() String
        +getLevelLife() int
        +getLevelAttack() int
        +getOffensiveEquip() OffensiveEquipment
        +setName(String) void
        +setLevelLife(int) void
        +setLevelAttack(int) void
        +setOffensiveEquip(OffensiveEquipment) void
        +toString() String
    }

    class Warrior {
        +String type = "WARRIOR"
        +Warrior(String)
        +toString() String
    }

    class Wizard {
        +String type = "WIZARD"
        +Wizard(String)
        +toString() String
    }

    class OffensiveEquipment {
        -String type
        -int attackLevel
        -String name
        +OffensiveEquipment(String, int, String)
        +getType() String
        +getAttackLevel() int
        +getName() String
        +setType(String) void
        +setAttackLevel(int) void
        +setName(String) void
        +toString() String
    }

    class DefensiveEquipment {
        -String type
        -int defenseLevel
        -String name
        +DefensiveEquipment(String, int, String)
        +getType() String
        +getDefenseLevel() int
        +getName() String
        +setType(String) void
        +setDefenseLevel(int) void
        +setName(String) void
        +toString() String
    }

    %% ============== CLASSES DE GESTION ==============
    class Game {
        +int NUM_TYPE_PLAYER = 2
        -Character player
        -Menu menu
        +Game()
        +getPlayer() Character
        +start() void
        +createPlayer() void
        +displayPlayer() void
        +modifyPlayer() void
    }

    class Menu {
        <<Singleton>>
        -Menu INSTANCE
        -Scanner scanner
        -Menu()
        +getInstance() Menu
        +intro() void
        +askPlayerTypeInt(String) int
        +askPlayerString(String) String
        +askModifyCharacter() boolean
    }

    class Main {
        +main() void
    }

    %% ============== RELATIONS ==============
    Character <|-- Warrior : heritage
    Character <|-- Wizard : heritage
    Character "1" o-- "1" OffensiveEquipment : possede
    Game "1" o-- "1" Character : player
    Game "1" --> "1" Menu : utilise
```

---

## 📋 Legende des Relations

| Symbole | Type de Relation | Description |
|---------|------------------|-------------|
| `<|--` | **Heritage** | `Warrior` et `Wizard` heritent de `Character` |
| `o--` | **Association** | `Character` possede un `OffensiveEquipment` |
| `-->` | **Dependance** | `Game` utilise `Menu` (via composition) |
| <<Singleton>> | **Pattern** | `Menu` est un Singleton |
| <<abstract>> | **Classe Abstraite** | `Character` est abstraite |

---

## 💡 Remarques & Suggestions d'Amelioration

1. **`DefensiveEquipment` n'est pas utilise** : La classe existe mais n'est pas integree dans `Character`. Tu pourrais ajouter :
   ```java
   private DefensiveEquipment defensiveEquip;
   ```

2. **Bug dans `Warrior.toString()`** : La methode affiche `"Wizard"` au lieu de `"Warrior"` (ligne 14)

3. **`Character` pourrait utiliser `DefensiveEquipment`** pour completer l'equipement

4. **Ajout possible** : Une classe `Equipment` (abstraite) comme parent de `OffensiveEquipment` et `DefensiveEquipment` pour factoriser le code commun
