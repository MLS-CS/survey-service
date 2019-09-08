package com.marketlogicsoftware.cs.surveyservice.survey.models;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Survey {
    @NotNull
    private String name;

    @NotNull
    private String description;

    private List<Question> questions;

    public Survey() {
    }

    public Survey(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
