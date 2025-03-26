# Système de Gestion de Vente en Ligne
[TD TP n°6 JAVA GI S6 24-25.pdf](https://github.com/user-attachments/files/19470623/TD.TP.n.6.JAVA.GI.S6.24-25.pdf)

## Description du Projet
Ce projet implémente un système de gestion de vente en ligne pour une société d'expédition d'articles. Il permet de gérer des articles, des clients, et différents types de colis avec des logiques de calcul de prix et d'expédition personnalisées.

## Fonctionnalités Principales
- Gestion des catégories d'articles avec différents taux de TVA
- Création et manipulation d'articles avec calcul automatique des prix
- Gestion des clients et de leurs colis
- Trois types de colis : 
  1. Colis Normal
  2. Colis Express
  3. Colis avec Assurance

## Structure du Projet
### Classes Principales
- `Categorie` : Gestion des catégories d'articles
- `Article` : Représentation des articles avec calcul de prix
- `Client` : Informations et gestion des clients
- `Colis` (Classe Abstraite) : Base pour les différents types de colis
  - `NormalColis`
  - `ExpressColis`
  - `AssuranceColis`
- `ServiceColis` : Gestion globale des colis

## Fonctionnalités Détaillées
### Calcul des Prix
- Prix TTC calculé automatiquement selon la catégorie
- Frais d'expédition basés sur le poids de l'article
  - < 5 kg : 5$
  - < 15 kg : 15$
  - > 15 kg : 0,75$ par kg

### Types de Colis
- **Colis Normal** : Frais d'expédition standard
- **Colis Express** : Frais d'expédition doublés
- **Colis Assuré** : Frais d'expédition avec surcharge d'assurance
  - < 100$ : Surcharge de 10$
  - ≥ 100$ : Surcharge de 5% de la valeur assurée

## Prérequis
- Java Development Kit (JDK) 8 ou supérieur
- Un IDE Java (Eclipse, IntelliJ IDEA, NetBeans) recommandé

## Installation
1. Clonez le dépôt
2. Ouvrez le projet dans votre IDE
3. Compilez et exécutez la classe `Main`

## Exemple d'Utilisation
```java
// Créer une catégorie
Categorie alimentaire = new Categorie("Alimentaire", Categorie.TVA10);

// Créer un article
Article article = new Article("Chocolat", 5.50, 500, alimentaire);

// Créer un client
Client client = new Client("email@example.com", "Dupont Jean", "123 Rue de Paris", "0612345678");

// Créer un colis
NormalColis colis = new NormalColis(1, client);
colis.addArticle(article);

// Expédier le colis
colis.ship();

// Obtenir le prix total
double prixTotal = colis.totalAmount();
```

## Fonctionnalités Avancées
- Comparaison des colis par poids
- Gestion dynamique des catégories
- Suivi des dates d'expédition

## Auteur
Université Hassan 1er
École Nationale des Sciences Appliquées – Berrechid
Cours : Programmation JAVA GI S6
Année Universitaire 2023-2024

## Licence
Projet académique - Usage éducatif uniquement

## Notes Importantes
- Les calculs de prix et d'expédition sont basés sur les spécifications du TP
- Le code est conçu pour démontrer les principes de programmation orientée objet
