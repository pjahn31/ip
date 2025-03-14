# Emily Task Manager

Emily Task Manager is a CLI-based desktop application for taking note of and managing tasks for users in a simple way!

## Features of Emily

### Adding Tasks: `todo` / `deadline` / `event`
Adds a task to the task manager. Tasks can be one of the three types: Todo, Deadline or Event. <br/>
Upon adding the task, the number of tasks in the current list will also be shown. <br/>
The type of task is indicated by a 'T' for todo, a 'D' for deadline and an 'E' for event. <br/>
- Add Todo: eg. `todo homework`, output `[T][ ] homework` <br/>
- Add Deadline: eg. `deadline assignment by thursday`, output `[D][ ] assignment (by: thursday) <br/>
- Add Event: eg. `event birthday party from 4pm to 7pm`, output `[E][ ] birthday party (from: 4pm to: 6pm)

### Listing all tasks: `list`
Displays all the tasks in the task list. This list is managed by Emily. <br/>
This list displayed has all the information - the type of task, whether it is marked or unmarked, description of the task.

### Mark/Unmark Tasks: `mark INDEX` / `unmark INDEX`
Marks or unmarks a task at the specified INDEX from the task list. <br/>
Mark is indicated by a 'X' next to the task. Unmark is indicated by an empty space. <br/>
- Mark task at index 1: eg. `mark 1`, output `[T][X] homework` <br/>
- Unmark task at index 1: eg. `unmark 1`, output `[T][ ] homework`

### Finding Tasks: `find KEYWORD`
Finds tasks in the task list with the corresponding KEYWORD in the task description. <br/>
Tasks with the KEYWORD is displayed as a list. <br/>
- Find tasks with keyword birthday: eg. `find birthday`

### Deleting Tasks: `delete INDEX`
Delete a task at the specified INDEX from the task list. <br/>
- Delete task at index 1: eg. `delete 1`

### Exiting the app: `bye`
Exits Emily Task Manager.

### Saving the data

Emily saves data in the hard disk automatically after any command that changes the task list.
There is no need to save manually.

### Editing the data file

Emily automatically saves your task list data in a text file located at "./Emily-storage.txt".
Advanced users are welcome to update data directly by editing the text file.