import java.util.ArrayList;
import java.util.List;


//creating an enum. Enums are used to create constant values.
enum TaskState {
    NotStarted, Started, Finished;
}

enum TaskDate {
    Today, Tomorrow, Someday;
}


class Task {

    private String t;
    private TaskState state;
    private TaskDate date;

    Task(String t) {
        this.t = t;
        state = TaskState.NotStarted;
    }


    //setting the day the task should be made.
    void setDate(int i) {
        switch (i) {
            case 1:
            date = TaskDate.Today;
            System.out.println("Date has been changed to Today");
            break;
            case 2:
            date = TaskDate.Tomorrow;
            System.out.println("Date has been changed to Tomorrow");
            break;
            case 3:
            date = TaskDate.Someday;
            System.out.println("Date has been changed to Someday");
            break;
            default:
            System.out.println("You have entered wrong Date!!!");
        }

    }

    //method for changing state of the Task
    void changeState(int i) {
        switch (i) {
            case 1:
            state = TaskState.Started;
            System.out.println("State has been changed to Started");
            break;
            case 2:
            state = TaskState.Finished;
            System.out.println("State has been changed to Finished");
            default:
            System.out.println("You have entered wrong State!!!");
        }
    }

    String getTask() {
        return this.t;
    }

}


// generic class for holding any type of Task
class ToDoList <T> {

    List<T> myToDo = new ArrayList<>();


    // creating a method for adding Task in array
    void addTask(T t) {
        myToDo.add(t);
    }

    void removeTask(int taskNum) {
        myToDo.remove(taskNum);
    }

    void showTasks() {
        for (T task : myToDo) {
            if (task instanceof String) {
                System.out.println(task);
            } else {
                // casting Generic <T> into task
                Task myt = (Task) task;
                System.out.println(myt.getTask());
            }
        }
    }

    void getLength() {
        System.out.println("There are " + myToDo.size() + " tasks for today");
    }

    

}


public class Main {
    public static void main(String[] args) {
        ToDoList<String> myTodo = new ToDoList<>();

        // Task task1 = new Task("Finish my ToDo list project");
        // Task task2 = new Task("Practice in git a little bit");
        // Task task3 = new Task("Clean my room");
        myTodo.addTask("Wash the dishes");
        myTodo.addTask("Mop the floor");
        myTodo.addTask("Clean my PC");
        myTodo.getLength();

        System.out.println();
        //displaying tasks assigned for today's day
        myTodo.showTasks();

        myTodo.removeTask(0);

        System.out.println("Your tasks for today after finishing two of them");
        myTodo.showTasks();
    }
}


