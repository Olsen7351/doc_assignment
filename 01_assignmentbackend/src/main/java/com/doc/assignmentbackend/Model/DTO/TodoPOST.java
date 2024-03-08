package com.doc.assignmentbackend.Model.DTO;

public class TodoPOST {
    private String title;
    private String description;
    public TodoPOST() {
    }

    public TodoPOST(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public TodoPOST title(String title) {
        this.title = title;
        return this;
    }

    public TodoPOST description(String description) {
        this.description = description;
        return this;
    }
}
