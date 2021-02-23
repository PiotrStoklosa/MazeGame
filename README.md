# MazeGame

## Hi!

This is my second project written in Java. MazeGame is the game, in which you have to escape from maze! There is one problem, this is not a classic maze. On the board you can notice a lot of small spots. If you walk onto this spot, you will get a certain effect! At the moment there is only one effect (changes the exit location to another randomly selected one), but in future I want to add more! The game is ready to download and play, but it's still developing. Below I advertise **how to run an app**, **instruction for users**, **the documentation for programmers** and **application extension prospects**!

## Table of contents
* [How to run an app](#How-to-run-an-app)
* [Instruction for users](#Instruction-for-users)
* [Documantation for programers](#Documantation-for-programers)
* [Application extension prospects](#Application-extension-prospects)

## How to run an app
1. Open any Java IDE.
2. Create new project.
3. Download source code and pictures from https://github.com/PiotrStoklosa/MazeGame.git
4. Run main in Main class.

## Instruction for users

MazeGame app is really simple to use! First of all, when you run a project you will see basic menu. Choose difficulty level and size of the board. After this you will see a process of creating your maze (look at the photo below, every time you will play on the new randomly generated board). 

![](https://i.imgur.com/vNnPpEW.png)

**white terrain**- not generated

**green square**- generated, but not finished

**purple square**- generated and finished

When the process is over, the game will begin (photo below)!

![](https://i.imgur.com/D0g0jEa.png)

You are Orange Guy, you can move with arrows and you have only one task! You have to find the exit! As I mentioned in the opening, each red spot has own effect. At the moment there is only one effect (changes the exit location to another randomly selected one). Sometimes you are forced to take an effect, so MazeGame is not easy as you think! Try it yourself, good luck!

If you have any questions, contact me!

## Documantation for programers

**Technologies:**
- Java
- Awt
- Canvas

Short info about some more important classes:

- ***MazeBlock*** stores an information about each block on the board (informations like walls, Orange Guy location, coordinates),
- ***Maze*** is responsible for generating a maze
- ***MazeModel / MazeView / MazeController*** MVC role,
- ***Effect*** represents an effect on the board, base class for particular effects (e.g. NewExit),
- ***MazeDraw*** is responsible for graphics (this class extends ***Canvas***).

Implemeted software designed patterns:
- MVC

## Application extension prospects

Application is still in developing process, below i advertise some of ideas that I want to implement:

1. New effects (rotation a board (90/180 degree), teleportation to random position etc.).
2. Upgrade board graphics.
