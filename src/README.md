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
                     ├──DB Connector                    
                     ├          └── DB manager
                     ├
                     ├── LoginManager.class
                     ├──  Menu.class       
                     ├── Scores.class
                     └──SignUp.class
                 ├──  Repository
                           ├── Entity
                                  └──  Person.class
                           ├──  Utility             
                                      └──  mysql-connector-java-8.0.33 jar
                 ├──  Services
                         └── Operations                 
                                  ├── Card.class
                                  ├── Deck.class
                                  ├── Easy.class
                                  ├── GameBoard.class
                                  ├── GameController,class
                                  ├──  Hard.class
                                  ├──  Levels.class             
                                  └──  Medium.class
    ├──   CompletieGame.java            
    ├── Application.java
    ├── memory_game_team2.iml
    └── README.MD
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
The Project is uploaded on Microsoft Github

### Step 3. Run the project
Run the project in your IDE or text editor.

## Instructions

When starting the application, the player is given the option to choose between 3 options. These are:

- **Exit game**. By choosing this option, the player/user exits the game.

- **Sign up**. Before being able to play the game, the player must first create an account. This can be done using the “sign up” option. The player will be asked to enter the username, date of birth and password. If the registration is successful, the player is registered in the system and can access the game.

- **Log in**. The player is asked to enter his or her username and password to access the game and is then transported to another menu which is where he he/she has  3 options again

- **play game**. The player is asked to enter his or her username and password to access the game and then play.

- **Exit game**. By choosing this option, the player/user exits the game.

- ** see leaderboard**. This allows the 10 highest scores with associated names to be retrieved.
- 
Once in the game the player will will be met with a level 1 card deck which has about 12 cards,Level 1 has 12 cards 
Level 2  has 20 cards and levl3 30 cards 
In each level the player/user has 10 mistakes that are allowed to be made

If the player has completed or made 10 mistakes in a level they have to option :
-**to retry**
-**head to the main menu **
-**exit the game **


 
