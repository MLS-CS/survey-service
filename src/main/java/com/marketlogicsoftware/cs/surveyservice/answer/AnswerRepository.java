package com.marketlogicsoftware.cs.surveyservice.answer;

import com.marketlogicsoftware.cs.surveyservice.survey.models.Answer;
import com.marketlogicsoftware.cs.surveyservice.survey.models.Survey;
import com.marketlogicsoftware.cs.surveyservice.survey.models.SurveyDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class AnswerRepository {
    @Autowired
    private MongoTemplate mongoTemplate;


    public void create(String surveyId, String questionId, Answer answer) {
        this.mongoTemplate.findAndModify(
                Query.query(Criteria.where("_id").is(surveyId))
                     .addCriteria(Criteria.where("survey.questions.id").is(questionId)),
                new Update().push("survey.questions.$.answers", answer),
                SurveyDocument.class
        );
    }

    public Survey retrieve(String surveyId) {
        return this.mongoTemplate.findById(surveyId, SurveyDocument.class).getSurvey();
    }


    public void update(String surveyId, String questionId, String id, Answer answer) {
        answer.setId(id);

        // Quick Fix
        this.delete(surveyId, questionId, id);
        this.create(surveyId, questionId, answer);

        /*
        this.mongoTemplate.findAndModify(
                Query.query(Criteria.where("_id").is(surveyId))
                     .addCriteria(Criteria.where("survey.questions.id").is(questionId))
                     .addCriteria(Criteria.where("survey.questions.answers.id").is(id)),
                new Update().set("survey.questions.answers.$", answer),
                SurveyDocument.class
        );
        */
    }

    public void delete(String surveyId, String questionId, String id) {
        this.mongoTemplate.findAndModify(
                Query.query(Criteria.where("_id").is(surveyId))
                     .addCriteria(Criteria.where("survey.questions.id").is(questionId)),
                new Update().pull("survey.questions.$.answers"
                        , new HashMap<String, String>()
                        {{
                            put("_id", id);
                        }}),
                SurveyDocument.class
        );
    }
}
