package com.marketlogicsoftware.cs.question;

import com.marketlogicsoftware.cs.survey.models.Survey;
import com.marketlogicsoftware.cs.survey.models.SurveyDocument;
import com.marketlogicsoftware.cs.survey.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class QuestionRepository {
    @Autowired
    private MongoTemplate mongoTemplate;


    public void create(String surveyId, Question question) {
        this.mongoTemplate.findAndModify(
                Query.query(Criteria.where("_id").is(surveyId)),
                new Update().push("survey.questions", question),
                SurveyDocument.class
        );
    }

    public Survey retrieve(String surveyId) {
        return this.mongoTemplate.findById(surveyId, SurveyDocument.class).getSurvey();
    }


    public void update(String surveyId, String id, Question question) {
        question.setId(id);

        this.mongoTemplate.findAndModify(
                Query.query(Criteria.where("_id").is(surveyId))
                     .addCriteria(Criteria.where("survey.questions.id").is(id)),
                new Update().set("survey.questions.$", question),
                SurveyDocument.class
        );
    }

    public void delete(String surveyId, String id) {
        this.mongoTemplate.findAndModify(
                Query.query(Criteria.where("_id").is(surveyId)),
                new Update().pull("survey.questions"
                        , new HashMap<String, String>()
                        {{
                           put("_id", id);
                        }}),
                SurveyDocument.class
        );
    }

}
