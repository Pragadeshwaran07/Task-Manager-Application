package com.jap.task;

public class Category {

    //declare an attribute categoryName
    private String categoryName;

    public Category(String categoryName){
        this.categoryName = categoryName;
    }

	public Category() {

	}
    //declare getter and setter and toString methods

    public String getCategoryName(){
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return categoryName;
    }
}
