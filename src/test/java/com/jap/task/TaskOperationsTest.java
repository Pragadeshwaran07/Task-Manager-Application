package com.jap.task;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TaskOperationsTest {
	private TaskOperations taskOperations;
	private Category category;
	private Task task;
	private User user;

	@Before
	public void setUp() throws Exception {
		taskOperations = new TaskOperations();
		category = new Category("Shopping");
		task = new Task("Buy Veggies", 3, "Go to supermarket to buy",false,category);
		user = new User("TestUser", "password");

	}

	@After
	public void tearDown() throws Exception {
		taskOperations = null;
		category=null;
		task=null;
		user=null;
	}

	@Test
	public void addNewTaskReturnTrue() {
		assertTrue(taskOperations.addTask(category, task, user));
	}


	@Test
	public void markTaskAsCompletedForValidInputReturnTrue() {
		taskOperations.addTask(category, task, user);
		assertTrue(taskOperations.markTaskAsCompleted("Buy Veggies", "completed"));
	}



	@Test
	public void removeTaskThatIsPresentReturnTrue() throws TaskNotFoundException {
		taskOperations.addTask(category, task, user);
		assertTrue(taskOperations.removeTask("Buy Veggies"));
	}

	@Test(expected = TaskNotFoundException.class)
	public void removeTaskThatIsNotPresentThrowException() throws TaskNotFoundException {
		taskOperations.removeTask("NonExistingTask");
	}

	@Test
	public void searchTasksByNameReturnTask() {
		Task matchingTasks = taskOperations.searchTasksByName("Buy Veggies");
		assertNull(matchingTasks);
	}
}
