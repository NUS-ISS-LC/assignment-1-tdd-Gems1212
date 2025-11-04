package sg.edu.nus.iss.epat.tdd.workshop;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ToDoList {
   private HashMap<String, Task> tasks = new HashMap<String, Task>();

   public void addTask(Task task) {
      // Add code here
      if (task != null && task.getDescription() != null)
      {
         tasks.put(task.getDescription(), task);
      }

   }

   public void completeTask(String description) {
      // Add code here
      Task task = tasks.get(description);
      if (task != null) {
         task.setComplete(true);
      }
   }

   public boolean getStatus(String description) {
      // Add code here
      Task task = tasks.get(description);
      if (task != null) {
         return task.isComplete();
      }
      return false;
   }

   public Task getTask(String description) {
      // Add code here
      return tasks.get(description);
   }

   public Task removeTask(String description) {
      // Add code here
      return tasks.remove(description);
   }

   public Collection<Task> getAllTasks() {
      return tasks.values();
   }

   public Collection<Task> getCompletedTasks() {
      // Add code here
      List<Task> completedTasks = new ArrayList<Task>();
      for (Task t: tasks.values()) {
         if (t.isComplete()) {
            completedTasks.add(t);
         }
      }
      return completedTasks;
   }
}
