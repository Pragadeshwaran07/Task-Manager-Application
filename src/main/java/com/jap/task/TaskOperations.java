package com.jap.task;

import java.util.*;

public class TaskOperations {
	//declare the attribute taskName,userTaskMap,categoryTaskMap
	private Set<String> taskNames;
	private Map<User, List<Task>> userTaskMap;
	private Map<Category, List<Task>> categoryTaskMap;

	public TaskOperations() {
		//initialize the attributes
		taskNames = new HashSet<String>();
		userTaskMap = new HashMap<User, List<Task>>();
		categoryTaskMap = new HashMap<Category, List<Task>>();
	}

	public boolean addTask(Category selectedCategory,Task task, User authenticatedUser) {
		//check if task is already present in taskNames
		//if present display appropriate message and return false;
		//if not present  get the userTask from the authenticatedUser.
		//check if UserTask not equal to null
		//initialize the list  and the task to the list.
		//if present just add the task to the list.
		//check if categoryTasks not equal to null
		//initialize the list  and the task to the list.
		//if present just add the task to the list.
		//add the task to the taskNames
		//return true
		if (taskNames != null && taskNames.contains(task.getTaskName())) {
			System.out.println("Task with this name already exists.");
			return false;
		}

		// Get the userTask from the authenticatedUser
		List<Task> userTasks = userTaskMap.get(authenticatedUser);
		if (userTasks == null) {
			userTasks = new ArrayList<Task>();
			userTaskMap.put(authenticatedUser, userTasks);
		}
		userTasks.add(task);

		// Check if categoryTasks contains the task
		List<Task> categoryTasks = categoryTaskMap.get(selectedCategory);
		if (categoryTasks == null) {
			categoryTasks = new ArrayList<Task>();
			categoryTaskMap.put(selectedCategory, categoryTasks);
		}
		categoryTasks.add(task);
		taskNames.add(task.getTaskName());

		return true;
	}
	public List<String> listAllTasks(String categoryName) {
	//fetch categories by categoryName  using getCategoryByName method of the category class
		//create a list of sortedTasks
		//if the selectedCategory is null display appropriate message
		//if selectedCategory is not null
		//generate a string "Category:  " + categoryName + " - " +"Name:  " +  taskName + " Priority:  " + taskPriority + " Description:  " + taskDescription + " Status:  " + isCompleted
		//add the string to the list and return the list
		Category selectedCategory = CategoryOperations.getCategoryByName(categoryTaskMap, categoryName);
		List<String> sortedTasks = new ArrayList<String>();

		if (selectedCategory == null) {
			System.out.println("No task found. ");
			return sortedTasks;
		}

		List<Task> tasks = categoryTaskMap.get(selectedCategory);
		for (Task task : tasks) {
			String taskDetails = "Category: " + categoryName + " - " + "Name: " + task.getTaskName() +
					", Priority: " + task.getPriority() + ", Description: " + task.getDescription() +
					", Status: " + (task.isCompleted() ? "Completed" : "In progress");
			sortedTasks.add(taskDetails);
		}
		return sortedTasks;
	}
	public boolean markTaskAsCompleted(String taskToComplete,String statusInput ) {
		//iterate the list of task from categoryTaskMap
		//check if the task with the given name is present
		//if the given statusInput is completed setCompleted to true and return true
		//if the given statusInput is pending setCompleted to false and return true
		//if the given statusInput is neither completed nor pending return false
		for (Map.Entry<Category, List<Task>> entry : categoryTaskMap.entrySet()) {
			for (Task task : entry.getValue()) {
				if (task.getTaskName().equalsIgnoreCase(taskToComplete)) {
					if ("completed".equalsIgnoreCase(statusInput)) {
						task.setCompleted(true);
						System.out.println(taskToComplete + " status is set to completed.");
						return true;
					} else if ("pending".equalsIgnoreCase(statusInput)) {
						task.setCompleted(false);
						System.out.println(taskToComplete + " status is set to pending.");
						return true;
					} else {
						System.out.println("Please enter appropriate status.");
						return false;
					}
				}
			}
		}
		System.out.println(
				"No task in the name '" + taskToComplete + "' found. Please enter the available task.");
		return false;
	}
	public boolean removeTask(String taskToRemove) throws TaskNotFoundException {
		//iterate the list of task from categoryTaskMap
		//check if the task with the given name is present
		// remove the task
		//remove the task from taskNames
		//return true if the task is removed
		//if task is not removed throw TaskNotFoundException
		for (Map.Entry<Category, List<Task>> entry : categoryTaskMap.entrySet()) {
			Iterator<Task> taskIterator = entry.getValue().iterator();
			while (taskIterator.hasNext()) {
				Task task = taskIterator.next();
				if (task.getTaskName().equalsIgnoreCase(taskToRemove)) {
					taskIterator.remove();
					taskNames.remove(taskToRemove);
					System.out.println("Task '" + task.getTaskName() + "' removed successfully.");
					return true;
				}
			}
		}
		throw new TaskNotFoundException("Task not found : " + taskToRemove);
	}
	public Task searchTasksByName(String taskName) {
		//iterate the list of task from categoryTaskMap
		//check if the task with the given name is present
		//add it to the matchingTaskList
		for (Map.Entry<Category, List<Task>> entry : categoryTaskMap.entrySet()) {
			for (Task task : entry.getValue()) {
				if (task.getTaskName().equalsIgnoreCase(taskName)) {
					return task;
				}
			}
		}
		return null;
	}
}

