# Requirements specification

## Purpose

A game that provides entertainment for people that have nothing better to do.

The game is about turtle races. You try to guess which turtle will win the race based on the provided information. 
Ideally the player can learn the effects of each piece of information and estimate the winner based on them with 100% accuracy.


## Interface

- Main screen / main menu
- Highscore screen
- Name choosing screen
- Game menu
- Statistics screen
- Racing screen

<img src="https://github.com/SirVeggie/otm-harjoitustyo/blob/master/Documentation/Pictures/Interface.png">

## Functionality

### Menus

- Highscores of previous games are shown.
- A session of gameplay can be created with a chosen name.
- A name that already exists in the highscore list can not be used.
- The name will be saved along with the session's highest score into the highscore list when exiting.
- Current session's scores can be check from the statistics section.

### Gameplay

- Each turtle has 4 pieces of information attached to them, which will determine how fast the turtle will proceed towards the goal.
- These attributes will be randomized.
- Attributes can for example change the turtle's linear speed or cause sudden changes to occur.
- Attribute categories are; Ability, Item, Temper and Handicap.
- There are 5 abilities, 4 items, 3 tempers and 5 handicaps.


- Each game lasts 5 rounds.
- Each round money is bet on a single turtle out of 5. (Support for varied amount of turtles is possible with minor changes)
- The bet amount cannot exceed the current amount of money.
- If the bet succeeds, the player is given back the lost bet money and awarded twice the amount of the bet.
- If money reaches zero at the end of a round, the player loses and receives the score of 0.
- After a race it is possible to investigate the results before continuing to the next round.
- After the game the player is notified of their final score.
