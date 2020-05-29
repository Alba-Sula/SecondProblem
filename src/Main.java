import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static Date enterDate() {
        int date;
        int month;
        int year;
        int hour;
        int min;
        System.out.println("Enter the date when you want this schedule to execute");
        date = sc.nextInt();
        System.out.println("Enter the month when you want this schedule to execute");
        month = sc.nextInt();
        System.out.println("Enter the year when you want this schedule to execute");
        year = sc.nextInt();
        System.out.println("Enter the hour when you want this schedule to execute");
        hour = sc.nextInt();
        System.out.println("Enter the minute when you want this schedule to execute");
        min = sc.nextInt();
        Date dateParsed = new Date();
        try {
            String toDate = "" + date + "/" + month + "/" + year + " " + hour + ":" + min;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            dateParsed = sdf.parse(toDate);
            Date currentDate = new Date();
            if (dateParsed.compareTo(currentDate) < 0) {
                System.out.println("Invalid date; please enter a date that is in the future");
                enterDate();
            }
        } catch (Exception e) {
            System.out.println("This exception was caught while parsing the date " + e);
        }

        return dateParsed;

    }

    public static SchedulesModel addingASchedule() {
        System.out.println("Enter the name of the schedule");
        String schName = sc.next();
        System.out.println("Enter the description of the schedule");
        String schDescription = sc.next();
        System.out.println("Enter 1 if you want the task to be repeatable and anything else if the task is not repeatable");
        int isRepeatable = sc.nextInt();
        int repetitionInMinutes;
        if (isRepeatable == 1) {
            System.out.println("Enter the time when to repeat the schedule in minutes");
            repetitionInMinutes = sc.nextInt();
        } else {
            repetitionInMinutes = 0;
        }
        System.out.println("Enter the duration of the task in minutes");
        int duration = sc.nextInt();
        System.out.println("Now we will get the date when this schedule must be run within the task");
        Date schStart = enterDate();
        SchedulesModel schedulesModel = new SchedulesModel(schName, schDescription, schStart, isRepeatable, repetitionInMinutes, duration);
        return schedulesModel;

    }

    public static TaskModel createTask() {
        System.out.println("Enter the name of the task");
        String taskName = sc.next();
        System.out.println("Enter the task description");
        String taskDescription = sc.next();
        System.out.println("You are now creating a list of schedules for the task created");
        System.out.println("Press 0 when you want to stop adding schedules for the task created");
        int schAddController = 1;
        ArrayList<SchedulesModel> schedulesModelList = new ArrayList<>();
        while (schAddController != 0) {
            SchedulesModel scheduleModel = addingASchedule();
            if (scheduleModel != null) {
                schedulesModelList.add(scheduleModel);
            }
            System.out.println("If you want to stop adding schedules to this task please enter 0, if not enter a random integer");
            schAddController = sc.nextInt();
        }
        TaskModel taskModel = new TaskModel(taskName, taskDescription, schedulesModelList);
        return taskModel;
    }


    public static void main(String[] args) {


        /*
         * this is where the arraylist of the tasks is completed
         */

        System.out.println("You are creating a new task, please follow the instructions along the way");
        ArrayList<TaskModel> taskModelList = new ArrayList<>();
        TaskModel taskModel = null;
        int taskAddController = 1;
        while (taskAddController == 1) {
            taskModel = createTask();
            if (taskModel != null) {
                taskModelList.add(taskModel);
            }
            System.out.println("Enter any integer number to stop adding tasks and enter 1 to continue adding them");
            taskAddController = sc.nextInt();
        }


        System.out.println("\n\n\n\n");



        /*
         * this is where the arraylist of tasks is serialised into json
         */


        Gson json = new Gson();
        String response = json.toJson(taskModelList);
        System.out.println(response);


        /*
         * after getting the json string we write the json file to save it
         */


        try (FileWriter file = new FileWriter("jsonFile.json")) {
            file.write(response);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * getting the data from the json file and than creating POJO with it
         */


        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("jsonFile.json"));
            JSONArray jsonArray = (JSONArray) obj;
            ArrayList<TaskModel> JsonToObjectArrayL = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject objects = (JSONObject) jsonArray.get(i);
                TaskModel tsk = new TaskModel();
                tsk.TaskName = (String) objects.get("TaskName");
                tsk.TaskDescription = (String) objects.get("TaskDescription");
                tsk.Schedules = (List<SchedulesModel>) objects.get("Schedules");
                JsonToObjectArrayL.add(tsk);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
