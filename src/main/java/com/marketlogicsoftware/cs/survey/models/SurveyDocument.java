package com.marketlogicsoftware.cs.survey.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Survey")
public class SurveyDocument {
    @Id
    private String id;
    private Survey survey;

    public SurveyDocument() {
    }

    public SurveyDocument(String is, Survey survey) {
        this.id = id;
        this.survey = survey;
    }

    public SurveyDocument(Survey survey) {
        this.survey = survey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
}
