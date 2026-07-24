# Diagramme de Classe - Donjons & Dragons

## Fichiers disponibles

Deux versions du diagramme de classe sont disponibles dans ce dossier :

### 1. **DiagrammeDeClasse.puml** (PlantUML)
Format standard pour la modélisation UML, compatible avec de nombreux outils.

**Comment visualiser :**
- **En ligne :** Copier le contenu dans [PlantText](https://www.planttext.com/) ou [PlantUML Web Server](http://www.plantuml.com/plantuml/)
- **VS Code :** Installer l'extension "PlantUML"
- **IntelliJ IDEA :** Installer le plugin PlantUML
- **Local :** Télécharger PlantUML JAR et exécuter : `java -jar plantuml.jar DiagrammeDeClasse.puml`

### 2. **DiagrammeDeClasse.mmd** (Mermaid)
Format léger supporté nativement par GitHub, GitLab et de nombreux éditeurs Markdown.

**Comment visualiser :**
- **GitHub/GitLab :** Le rendu se fait automatiquement dans le README
- **VS Code :** Installer l'extension "Mermaid Preview"
- **En ligne :** Utiliser [Mermaid Live Editor](https://mermaid.live/)

## Structure du Projet

### Hiérarchie des Classes

```
Main
├── Game
│   ├── Menu (Singleton)
│   ├── Dice
│   ├── Board
│   │   └── Cell[64] (Record)
│   └── Character (Abstract)
│       ├── Warrior
│       └── Wizard
│
Character
└── OffensiveEquipment

DefensiveEquipment (non utilisé actuellement dans Game)
```

### Classes Principales

1. **Main** - Point d'entrée du programme
2. **Game** - Logique principale du jeu
3. **Menu** - Interface utilisateur (Singleton)
4. **Dice** - Génération aléatoire des lancers
5. **Board** - Plateau de 64 cases
6. **Cell** - Une case du plateau (Java Record)
7. **Character** - Classe abstraite pour les personnages
8. **Warrior** - Type de personnage (PV: 10, Attaque: 5)
9. **Wizard** - Type de personnage (PV: 7, Attaque: 7)
10. **OffensiveEquipment** - Équipement offensif (arme/sort)
11. **DefensiveEquipment** - Équipement défensif (bouclier/potion)

### Relations

- **Héritage :** Character ← Warrior, Character ← Wizard
- **Association :** Game → Character, Character → OffensiveEquipment
- **Composition :** Board → Cell (64 instances)
- **Utilisation :** Game → Menu, Game → Dice, Game → Board

### Patterns Utilisés

- **Singleton :** Menu (une seule instance accessible via getInstance())
- **Record :** Cell (classe immutable avec générateur automatique de getters, equals, hashCode)
- **Classe Abstraite :** Character (ne peut pas être instanciée directement)
