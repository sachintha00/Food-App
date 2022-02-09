package com.smd.foodmaster.model;

public class Category {
    String categoryTitle;

    public Category(String categoryTitle){
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryTitle(){
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle){
        this.categoryTitle = categoryTitle;
    }
}
