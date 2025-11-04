package sg.edu.nus.iss.epat.tdd.workshop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Collection;

public class ToDoListTest  {
    // Define Test Fixtures
    private ToDoList toDoList;
    private Task task1;
    private Task task2;
    private Task task3;

    public ToDoListTest() {
        
        super();
    }

    @Before
    public void setUp() throws Exception {
        // Initialise Test Fixtures
        toDoList = new ToDoList();
        task1 = new Task("Sleeping");
        task2 = new Task("Eating");
        task3 = new Task("Playing", true);
        toDoList.addTask(task1);
        toDoList.addTask(task2);
        toDoList.addTask(task3);
      
    }

    @After
    public void tearDown() throws Exception {
        // Uninitialise test Fixtures
        toDoList = null;
        System.out.println("tearDown");
      
    }

    @Test
    public void testAddTask() {
        Task newTask = new Task("New Task1");
        toDoList.addTask(newTask);   
        Task fetched = toDoList.getTask("New Task1");
        assertNotNull("Task should be added to the list", fetched);
        assertEquals("Task description should match", "New Task1", fetched.getDescription());
        //fail("Not implemented yet");
    }

    @Test
    public void testGetStatus() {
        assertTrue("Completed task should return true", toDoList.getStatus("Playing"));
        assertFalse("Incomplete task should return false", toDoList.getStatus("Eating"));
        //fail("Not implemented yet");
    }

    @Test
    public void testRemoveTask() {
        Task removed = toDoList.removeTask("Eating");
        assertNotNull("Removed task should not be null", removed);
        assertEquals("Removed task should be 'Eating'", "Eating", removed.getDescription());
        assertNull("Removed task should no longer exist in list", toDoList.getTask("Eating"));
        //fail("Not implemented yet");
    }

    @Test
    public void testGetCompletedTasks() {
        toDoList.completeTask("Sleeping");

        Collection<Task> completedTasks = toDoList.getCompletedTasks();
        assertEquals("There should be 2 completed tasks", 2, completedTasks.size());
        assertNotNull("The List should not be null", completedTasks);
        assertTrue(completedTasks.stream().anyMatch(t -> t.getDescription().equals("Sleeping")));
        assertTrue(completedTasks.stream().anyMatch(t -> t.getDescription().equals("Playing")));
        //fail("Not implemented yet");
    }
}