# MyLifeInStarDew
Simulates a task management system for daily activities/tasks based on the Stardew Valley game.

## Getting Started
Clone the repository or download the files.
Open the project in your favorite Java IDE.
Compile and run the MyLifeInStarDew.java file.
Methods
**showUsage()**
Shows the usage for the program.

**processArguments(String[] args)**
Processes the arguments for the program.

**getTaskType(double luckOfTheDay)**
Gets the type of Task based on Luck of the Day, random probability, and current energy levels.

**getDetails(TaskInterface.TaskType taskType)**
Gets the details of a particular Task specific to each sub-category of Task.

# Usage
The program can be run from the command line with the following arguments:

```
java MyLifeInStarDew  <max-priority> <time-to-increment-priority> <total simulation-time in days> <task-generation-probability> [<seed>]
```
max-priority : The maximum priority level for the tasks. Must be greater than or equal to 1.
time-to-increment-priority : The time required to increment a task's priority level. Must be greater than or equal to 1.
total simulation-time in days : The total simulation time in days. Must be greater than or equal to 1.
task-generation-probability : The probability of generating a task each day. Must be between 0 and 1.
seed (optional) : The seed for the random number generator.
Example usage:

```
java MyLifeInStarDew 5 3 10 0.5
```
## Contributing
Contributions are welcome. Please create a pull request with your changes.

## License
This project is licensed under the MIT License - see the LICENSE file for details.