# Game testing

## Component testing and component integration testing

### Logic

The methods and classes that handle the game's logic are tested with automatic JUnit testing.
Component testing has been done at a pretty good level, but integration testing quality is not as good.

Some classes have extra methods implemented to help perform better testing.

### Dao

Automatic testing of the Dao classes is minimal, but there has been a lot of manual testing.

### Test coverage

Here's an overview of the test coverage:

image here

## System testing

The system testing has been done manually.

### Files

The game will create all the files it needs if they are not found, even during the game is running, thus preventing problems.
The game has been tested with different config values and all appropriate values as determined in the config should work. If the round count is set too high (999999+), it will simply reset the config file.

### In-game testing

The game's interface itself is not overly complicated, and the user has limited options on what to do.
Therefore all possible actions that a user can take have been tested.
If the additional files do not have a problem, the game is most likely going to work 100%.

## Problems

If the game does not have access to the predetermined file paths, then it will most likely not work.
