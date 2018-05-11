
# Architecture

## Structure

Package structure:

<img src="https://github.com/SirVeggie/otm-harjoitustyo/blob/master/Documentation/Pictures/l-11.png" width="160">

- turtlerace.ui includes the classes responsible of javaFX and the main class

- turtlerace.domain includes the classes responsible for software logic

- turtlerace.dao includes the classes responsible for data management with the use of a database and a config file

## Interface

The interface has several scenes which the user can navigate through the buttons placed at the center of the screen. 
It has two menu screens, two scorekeeping scenes, a name choosing scene and the actual game itself.

This has been done using javaFX. Swapping scenes is done by switching the active scene currently set to the stage. 
Scenes are usually reset just before switching them when moving about the interface.

The interface has minimal game logic code in it. It creates a Logic class which is then called when a logic operation is needed. 
Some operations are done directly on the javaFX method if they are very simple, or cannot easily be moved to another class.

The only scene where the screen is refreshed repeatedly is the race scene, where the turtles positions are calculated and refreshed 4 times in a second. When the race hasn't started yet, or it has already ended, the scene isn't being refreshed.

## Logic

### Overview of the classes

The 'big brother' of the game's logic is the Logic class. The logic class is called from the interface whenever the user performs actions. The logic class then either does simple operations directly by itself, or calls other classes for extra information or more extensive operations. It is also responsible for initializing and utilizing the dao classes.

Highscore class is used solely as a tool to more easily use the dao classes, and does not contain any operations.

Player class is used to hold the current player's information, and perform a couple manipulations on that information.

Turtle class simply holds it's id/placement in the race, and 4 random variables. It can also be used to generate it's description based on what those 4 variables are.

Race class initializes and holds the information of the current race/round, and uses the RaceLogic class to calculate the positions of the turtles as well as check if any of the turtles have reached the finish line.

RaceLogic only has a single method to calculate the given turtle's movement for the next step/frame.

## Permanent data storage



## Weaknesses

Due to inexperience with javaFX, all of the code is placed in a single method. It would be smarter to try separating it into multiple smaller methods. Especially creating each new scene in a separate method could work great, although accessing elements from other scenes would prove difficult in this case. Due to time constraints the already finished javaFX code was not re-designed after the fact.

Dao code could most likely be optimized greatly as well. The dao classes are also missing proper testing.
