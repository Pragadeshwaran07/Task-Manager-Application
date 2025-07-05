package com.jap.task;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskManager {

    // Attributes for category and task operations
    private CategoryOperations categoryOperations;
    private TaskOperations taskOperations;

    /**
     * Constructs a new TaskManager object. Initializes category and task operation objects.
     */
    public TaskManager() {
        // Initialize category and task operation objects
        categoryOperations = new CategoryOperations();
        taskOperations = new TaskOperations();
    }

    /**
     * Allows the authenticated user to interact with the task manager by providing menu choices.
     *
     * @param authenticatedUser The authenticated user accessing the task manager.
     */
    public void takeChoices(User authenticatedUser) {
        Scanner scanner = new Scanner(System.in);
        String categoryName;
        String taskName;
        Category selectedCategory;
        int choice = 0;

        // Display the menu options and handle user choices until the user chooses to exit
        do {
            System.out.println("\nTask Manager Menu");
            System.out.println("1. Add a Task");
            System.out.println("2. List all Tasks");
            System.out.println("3. Mark a Task as Completed");
            System.out.println("4. Remove a Task");
            System.out.println("5. Add a Category");
            System.out.println("6. List all Categories");
            System.out.println("7. Search for a Task by Name");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("The entered choice is not a valid number.");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter category name: ");
                    categoryName = scanner.nextLine();
                    selectedCategory = categoryOperations.findCategory(categoryName);
                    if (selectedCategory == null) {
                        System.out.println("Category not found. Please create the category first.");
                    } else {
                        System.out.print("Enter task name: ");
                        taskName = scanner.nextLine();
                        while (taskOperations.searchTasksByName(taskName) != null) {
                            System.out.println("Task with this name already exists.");
                            System.out.print("Enter task name: ");
                            taskName = scanner.nextLine();
                        }

                        System.out.print("Enter priority (1 - 5): ");
                        int priority = scanner.nextInt();
                        while (priority < 0 || priority > 5) {
                            System.out.println("Please enter the priority from 1 to 5.");
                            System.out.print("Enter priority (1 - 5): ");
                            priority = scanner.nextInt();
                        }
                        scanner.nextLine();
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        Task task = new Task(taskName, priority, description, false, selectedCategory);
                        taskOperations.addTask(selectedCategory, task, authenticatedUser);
                    }
                    break;
                case 2:
                    // List all tasks
                    // Enter category name and list tasks
                    System.out.print("Enter category name: ");
                    categoryName = scanner.nextLine();
                    System.out.println(taskOperations.listAllTasks(categoryName));
                    break;
                case 3:
                    // Mark a task as completed
                    // Get the task name and task status
                    System.out.print("Enter task name: ");
                    taskName = scanner.nextLine();
                    System.out.print("Enter task status (completed/pending): ");
                    String status = scanner.nextLine();
                    taskOperations.markTaskAsCompleted(taskName, status);
                    break;
                case 4:
                    // Remove a task
                    // Enter task name and handle exceptions
                    System.out.print("Enter the task name to remove: ");
                    taskName = scanner.nextLine();
                    try {
                        taskOperations.removeTask(taskName);
                    } catch (TaskNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    // Add a new category
                    // Enter category name
                    System.out.print("Enter category name: ");
                    categoryName = scanner.nextLine();
                    categoryOperations.addCategory(categoryName);
                    break;
                case 6:
                    // List all categories
                    System.out.println("Listing all categories: ");
                    for (Category category : categoryOperations.listAllCategories()) {
                        System.out.println(category.getCategoryName());
                    }
                    break;
                case 7:
                    // Search for a task by name
                    // Enter task name to search
                    System.out.print("Enter task name to search: ");
                    String searchTaskName = scanner.nextLine();
                    Task task = taskOperations.searchTasksByName(searchTaskName);
                    if (task != null) {
                        System.out.println("Found task: " + task);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 8:
                    // Exit the program
                    System.out.println("Exiting Task Manager...");
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                    break;
            }
        } while (choice != 8);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
