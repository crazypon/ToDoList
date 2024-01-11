import java.util.ArrayList;
import java.util.List;

class ToDoList {
    List<String> myToDo = new ArrayList<>();

    // creating a method for adding Task in array
    void addTask(String t) {
        myToDo.add(t);
    }

    void removeTask(int taskNum) {
        myToDo.remove(taskNum);
    }

    void showTasks() {
        for (String task : myToDo) {
            System.out.println(task);
        }
    }

    void getLength() {
        System.out.println("There are " + myToDo.size() + " tasks for today");
    }

}

public class Main {
    public static void main(String[] args) {
        ToDoList myTodo = new ToDoList();

        myTodo.addTask("Finish my ToDo list project");
        myTodo.addTask("Practice in git a little bit");
        myTodo.addTask("Clean my room");

        System.out.println("You tasks for today are: ");
        //displaying tasks assigned for today's day
        myTodo.showTasks();
        myTodo.getLength();

        myTodo.removeTask(0);

        System.out.println("Your tasks for today after finishing two of them");
        myTodo.showTasks();
    }
}


