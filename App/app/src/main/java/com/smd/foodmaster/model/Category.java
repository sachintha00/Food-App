package com.smd.foodmaster.model;

import java.util.List;

public class Category {
    private String nameCategory;
    private List<Food> foodList;

    public Category(String nameCategory, List<Food> foodList) {
        this.nameCategory = nameCategory;
        this.foodList = foodList;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
