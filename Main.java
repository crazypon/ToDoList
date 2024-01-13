import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//creating an enum. Enums are used to create constant values.
enum TaskState {
    NOT_STARTED, STARTED, FINISHED;
}

enum TaskDate {
    TODAY, TOMORROW, SOMEDAY;
}


class Task {

    private String t;
    public TaskState state;
    private TaskDate date;

    Task(String t) {
        this.t = t;
        state = TaskState.NOT_STARTED;
    }


    //setting the day the task should be made.
    void setDate(int i) {
        switch (i) {
            case 1:
            date = TaskDate.TODAY;
            System.out.println("Date has been changed to Today");
            break;
            case 2:
            date = TaskDate.TOMORROW;
            System.out.println("Date has been changed to Tomorrow");
            break;
            case 3:
            date = TaskDate.SOMEDAY;
            System.out.println("Date has been changed to Someday");
            break;
            default:
            System.out.println("You have entered wrong Date!!!");
        }

    }

    //method for changing state of the Task
    void setState(int i) {
        switch (i) {
            case 1:
            state = TaskState.STARTED;
            System.out.println("State has been changed to Started");
            break;
            case 2:
            state = TaskState.FINISHED;
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
        System.out.println("There are " + myToDo.size() + " tasks for today: ");
    }

    void getFinishedTasks() {
        for(T task : myToDo) {
            if(task instanceof Task) {
                Task myt = (Task) task;
                if(myt.state == TaskState.FINISHED) {
                    System.out.println(myt.getTask());
                }
            }
    }
}


public class Main {

    static ToDoList<Task> myTodo = new ToDoList<>();    

    static void addTasks() {
        try (Scanner scanner = new Scanner(System.in)) {

            while(true) {
                System.out.println("What task do you want to add?");
                String newTask = scanner.nextLine();
                if(newTask.equals("stop")) {
                    break;
                }
                myTodo.addTask(new Task(newTask));
                System.out.println("\nTask has been successfully added");
            }
        }

    }
    public static void main(String[] args) {

        //a loop for keeping asking user what does he want
        while(true) {
            try(Scanner cli = new Scanner(System.in)) {
                System.out.println("What do you want to make?");
                System.out.println("1. Add tasks");
                System.out.println("2. Edit task");
                System.out.println("3. Crossout task");
                
                String userAnswer = cli.nextLine();

                if(userAnswer.equals("1")) {
                    addTasks();
                } else if(userAnswer.equals("2")) {
                    System.out.println("What task you want to change?");


                    String whatToEdit = cli.nextLine();

                    if(whatToEdit.equals("1")) {
                        task.setState(1);
                    }
                }

                
                
            }
        }

        myTodo.getLength();

        System.out.println();
        //displaying tasks assigned for today's day
        myTodo.showTasks();

        myTodo.removeTask(0);

        System.out.println("Your tasks for today after finishing two of them");
        myTodo.showTasks();
    }
}


