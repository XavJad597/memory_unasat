<h1 align="center">
  Memory Game
</h1>
This project was made with java.

## Table of Contents
- [1. Getting Started](#1-getting-started)
    - [1.1 Folder Structure](#1.1-folder-structure)
    - [1.2 Tools Required](#1.2-tools-required)
- [2. Development](#2-development)
    - [2.1 Set up the project](#21-set-up-the-project)
      - [Step 1: Install Java JDK](#step-1-install-java-jdk)
      - [Step 2: Download the project from Teams](#step-2-download-the-project-from-teams)
      - [Step 3: Run the project](#step-3-run-the-project)



# 1. Getting Started
This project was commissioned by subject teachers we made a memory game with java.

## 1.1 Folder Structure
The folder structure of the workspace contains:
```
    memory_game_Unasat
    ├── .idea
    ├── database asset
        └── memory.sql
    ├── out
    ├── src
          ├──com
              ├──unasat
                 ├── config
                     ├──dbconnector                    
                     ├          └── DatabaseManager
                     ├
                     ├── LoginManager.java
                     ├── Menu.java       
                     ├── Scores.java
                     └── SignUp.java
                 ├──  repository
                           ├── entity
                                  └──  Person.java
                           ├── utility             
                                      └──  mysql-connector-java-8.0.33.jar
                 ├──  services
                         └── operations                 
                                  ├── Card.java
                                  ├── Deck.java
                                  ├── Easy.java
                                  ├── GameBoard.java
                                  ├── GameController.java
                                  ├──  Hard.class
                                  ├──  Levels.class             
                                  └──  Medium.class

    ├── README.MD
    ├── CompleteGame.java            
    ├── Application.java
    └──memory_game_unasat.iml
    
```
## 1.2 Tools Required
The workspace following tools to develop and run the project:
- A text editor(like [VS Code](https://code.visualstudio.com/)) or an IDE (like [IntelliJ](https://www.jetbrains.com/idea/)))
- Java Development Kit such as [Oracle JDK 17 or newer](https://www.oracle.com/java/technologies/java-se-glance.html) or [Amazon Corretto 17 or newer](https://aws.amazon.com/corretto/)

# 2. Development

## 2.1 Set up the Project
The steps to run the project:

### Step 1. Install Java JDK
You can either use Amazon Corretto or Oracle JDK. 

### Step 2. Download the project from Github
The Project is uploaded on  Github

### Step 3. Run the project
Run the project in your IDE or text editor.

## Instructions

When starting the application, the player will be presented with 3 options. They are:

- **Sign up**. Before being able to play the game, the player must first create an account. This can be done using the “sign up” option. The player will be asked to enter the username, date of birth and password. If the registration is successful, the player is registered in the system and can access the game. They will have to log in again to go to the main menu.
  
- **Log in**. The player is asked to enter his or her username and password to access the game. After succesfully logging in, the player will be transported to the main menu. In which they will be presented with 3 options.

- **Exit game**. By choosing this option, the player/user exits the game.

- **Play Game**. The player is asked to enter his or her username and password to access the game, so that they can then play it.

- **See Leaderboard**. This allows the 10 highest scores with associated names to be retrieved.
- 
- **Exit Game**. By choosing this option, the player/user will exit the game.

  
Once in the game, the player will be presented with the first level which has 12 cards.
If completed, the player will then go to the next level.

There are a total of 3 levels, each with their own respective deck.
Level 1's deck has 12 cards, level 2's deck has 20 cards and level 3's deck has 30 cards. 
In each level the player/user has 10 mistakes that are allowed to be made

If the player has made 10 mistakes they will return to the main menu 

 
