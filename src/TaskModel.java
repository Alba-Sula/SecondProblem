import java.util.List;

public class TaskModel {
    public String TaskName;
    public String TaskDescription;
    List<SchedulesModel> Schedules;

    public TaskModel(String taskName, String taskDescription, List<SchedulesModel> schedules) {
        TaskName = taskName;
        TaskDescription = taskDescription;
        Schedules = schedules;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public String getTaskDescription() {
        return TaskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        TaskDescription = taskDescription;
    }

    public List<SchedulesModel> getSchedules() {
        return Schedules;
    }

    public void setSchedules(List<SchedulesModel> schedules) {
        Schedules = schedules;
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "TaskName='" + TaskName + '\'' +
                ", TaskDescription='" + TaskDescription + '\'' +
                ", Schedules=" + Schedules.toString() +
                '}';
    }
}