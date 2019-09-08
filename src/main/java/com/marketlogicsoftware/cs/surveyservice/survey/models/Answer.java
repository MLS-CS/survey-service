package com.marketlogicsoftware.cs.surveyservice.survey.models;

public class Answer {
    private String id;
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
