# Turtle Race

A game about racing turtles. You as the player are provided information of the racing turtles, which you are to use to deduce how well each turtle will perform in the race. Essentially to correctly choose the winning turtle.

## Documentation
[Work hours](https://github.com/SirVeggie/otm-harjoitustyo/blob/master/Documentation/work_hours.md)

[Requirements specification](https://github.com/SirVeggie/otm-harjoitustyo/blob/master/Documentation/requirements_specification.md)

[Architecture](https://github.com/SirVeggie/otm-harjoitustyo/blob/master/Documentation/architecture.md)


## Command line actions

### Testing

Test command:

```
mvn test
```

Test coverage report:

```
mvn test jacoco:report
```

The report can be found in here: target/site/jacoco/index.html

### Executable jar file

Jar command:

```
mvn package
```

generates the _TurtleRace-1.0-SNAPSHOT.jar_ jar file into the _target_ folder.

### JavaDoc --NOT DONE YET--

JavaDoc command:

```
mvn javadoc:javadoc
```

JavaDocia found in _target/site/apidocs/index.html_

### Checkstyle

Checkstyle command:

```
mvn jxr:jxr checkstyle:checkstyle
```
