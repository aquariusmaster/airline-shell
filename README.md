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

## Using

List of commands:

   - **all**: Show all aircrafts (with optional sorted by flight range)
   - **add**: Add new aircraft
   - **get**: Get aircraft by id
   - **total**: Calculate total capacity and carrying capacity of all the aircraft in the airline
   - **find**: Find aircraft corresponding to the specified range of fuel consumption parameters (liters per hour)
   - **clear**: Clear the screen.
   - **exit**: Exit from programm.
   
Use `help` or `help <commmand>` to get more information about commands.

## Examples

   ```all``` - show all aircrafts in company
   
   ```all -sorted``` - show all aircrafts sorted by flight range
   
   ```get 4``` - get AirCraft with id 4
   
   ```add 35.6 100 32 30.9``` - save new AirCraft
   
   ```total``` - show total capacity with total carrying capacity
   
   ```total -capacity``` - show total capacity of all AirCrafts in the company
   
   ```total -carrying``` - show total carrying capacity
   
   ```find -range 5000 15000``` - show all AirCrafts in range of fuel consumption parameters from 5000 to 15000 (liters per hour)
