package com.jap.task;

import java.util.*;

/**
 * The CategoryOperations class provides operations related to managing categories.
 */
public class CategoryOperations {

	// Declare the categories attribute
	// This attribute will hold all the categories

	private List<Category> categories;

	public CategoryOperations() {
		// Initialize the categories list
		categories = new ArrayList<Category>();
	}

	public boolean addCategory(String categoryName) {
		// Check if the category with the same name already exists
		// If the category is present, return false
		// If the category is not present, add the category and return true
		for (Category category : categories) {
			if (category.getCategoryName().equalsIgnoreCase(categoryName)) {
				System.out.println("Category already exists.");
				return false;
			}
		}
		categories.add(new Category(categoryName));
		System.out.println("Category '" + categoryName + "' added successfully.");
		return true;
	}

	public Category findCategory(String categoryName) {
		// Check if categories list is empty
		// If empty, return null
		// If not empty, iterate through the list to find if the given categoryName is present
		// If present, return the category, otherwise return null
		if (!categories.isEmpty()) {
			for (Category category : categories) {
				if (category.getCategoryName().equalsIgnoreCase(categoryName)) {
					return category;
				}
			}
		}
		return null;
	}

	public List<Category> listAllCategories() {
		// Display the categories and return the same
		return categories;
	}

	public static Category getCategoryByName(Map<Category, List<Task>> categoryTaskMap, String categoryName) {
		Category categoryByName = null;
		// Get the keySet from the categoryTaskMap
		// Check if the given categoryName is present in the map
		// If the name is present, return the category, otherwise return null
		for (Map.Entry<Category, List<Task>> entry : categoryTaskMap.entrySet()) {
			if (entry.getKey().getCategoryName().equalsIgnoreCase(categoryName)) {
				categoryByName = entry.getKey();
				break;
			}
		}

		return categoryByName;
	}
}
