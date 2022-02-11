package com.smd.foodmaster.model;

public class Food {
    private int resourceId;
    private String title;
    private String description;

    public Food(int resourceId, String title, String description) {
        this.resourceId = resourceId;
        this.title = title;
        this.description = description;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
