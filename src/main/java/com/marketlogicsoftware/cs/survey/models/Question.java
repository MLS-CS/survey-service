package com.marketlogicsoftware.cs.survey.models;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Question {
    private String id;

    @NotNull
    private String description;

    @NotNull
    private String category;

    @NotNull
    private AnswerType answerType;

    private List<Answer> answers;

    public Question(){}

    public Question(String description, String category, AnswerType answerType) {
        this.description = description;
        this.category = category;
        this.answerType = answerType;
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

    public String getCategory() {
        return category;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
