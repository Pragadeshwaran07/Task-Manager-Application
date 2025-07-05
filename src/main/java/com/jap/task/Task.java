package com.jap.task;

public class Task {

    //declare the attributes taskName, priority, description, isCompleted, category
    private String taskName;
    private int priority;
    private String description;
    private boolean isCompleted;
    private Category category;

    public Task(String taskName, int priority, String description, boolean isCompleted, Category category) {
        this.taskName = taskName;
        this.priority = priority;
        this.description = description;
        this.isCompleted = isCompleted;
        this.category = category;
    }

	public Task() {

	}

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    //declare getter setter and toString method


    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                ", category=" + category +
                '}';
    }
}
