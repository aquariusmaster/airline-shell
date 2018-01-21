# Airline CLI
Airline company that stores airplanes
## Building
```
mvn package
```
## Running
The project comes with a sample application, showcasing the various ways you can write commands.
```
mvn spring-boot:run
```
or run as jar
```
java -jar spring-shell.jar
```
From there, use commands at the shell prompt.

##Using

List of commands:

   - **all**: Show all aircrafts (with optional sorted by flight range)
   - **add**: Add new aircraft
   - **get**: Get aircraft by id
   - **total**: Calculate total capacity and carrying capacity of all the aircraft in the airline
   - **find**: Find aircraft corresponding to the specified range of fuel consumption parameters (liters per hour)

Use `help` or `help <commmand>` to get more information about commands.