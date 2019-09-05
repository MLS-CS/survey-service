package com.marketlogicsoftware.cs.surveyservice.survey.models;

import java.util.List;

public class Question {
    private String id;
    private String description;
    private String cateory;
    private AnswerType answerType;
    private List<Answer> answers;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCateory() {
        return cateory;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
