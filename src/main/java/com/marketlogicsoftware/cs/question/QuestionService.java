package com.marketlogicsoftware.cs.question;

import com.marketlogicsoftware.cs.survey.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public String createQuestion(String surveyId, Question question) {
        question.setId(UUID.randomUUID().toString());

        questionRepository
                .create(surveyId, question);

        return question.getId();
    }

    public Question retrieveQuestion(String surveyId, String id) {
        return questionRepository
                .retrieve(surveyId)
                .getQuestions()
                .stream()
                .filter(question -> question.getId().equals(id))
                .findFirst()
                .get();
    }

    public void updateQuestion(String surveyId, String id, Question question) {
        questionRepository.update(surveyId, id, question);
    }

    public void deleteQuestion(String surveyId, String id) {
        questionRepository.delete(surveyId, id);
    }
}
