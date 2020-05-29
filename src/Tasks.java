import java.util.ArrayList;

public class Tasks {
    public Tasks() {
    }

    public ArrayList<TaskModel> tasks;

    public Tasks(ArrayList<TaskModel> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<TaskModel> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<TaskModel> tasks) {
        this.tasks = tasks;
    }


}
