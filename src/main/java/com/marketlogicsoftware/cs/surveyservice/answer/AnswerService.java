package com.marketlogicsoftware.cs.surveyservice.answer;

import com.marketlogicsoftware.cs.surveyservice.survey.models.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public String createAnswer(String surveyId, String questionId, Answer answer) {
        answer.setId(UUID.randomUUID().toString());

        answerRepository
                .create(surveyId, questionId, answer);

        return answer.getId();
    }

    public Answer retrieveAnswer(String surveyId, String questionId, String id) {
        return answerRepository
                .retrieve(surveyId)
                .getQuestions()
                .stream()
                .filter(question -> question.getId().equals(questionId))
                .findFirst()
                .get()
                .getAnswers()
                .stream()
                .filter(answer -> answer.getId().equals(id))
                .findFirst()
                .get();
    }

    public void updateAnswer(String surveyId, String questionId, String id, Answer answer) {
        answerRepository.update(surveyId, questionId, id, answer);
    }

    public void deleteAnswer(String surveyId, String questionId, String id) {
        answerRepository.delete(surveyId, questionId, id);
    }
}
