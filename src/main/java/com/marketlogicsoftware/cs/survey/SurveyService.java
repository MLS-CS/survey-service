package com.marketlogicsoftware.cs.survey;

import com.marketlogicsoftware.cs.survey.models.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;

    public String createSurvey(Survey survey) {
        return surveyRepository.create(survey);
    }

    public Survey retrieveSurvey(String id) {
        return surveyRepository.retrieve(id);
    }

    public void updateSurvey(String id, Survey survey) {
        surveyRepository.update(id, survey);
    }

    public void deleteSurvey(String id) {
        surveyRepository.delete(id);
    }
}
