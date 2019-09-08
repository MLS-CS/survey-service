package com.marketlogicsoftware.cs.survey.models;

import javax.validation.constraints.NotNull;

public class Answer {
    private String id;

    @NotNull
    private String description;

    public Answer(){}

    public Answer(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
}
