package com.marketlogicsoftware.cs.survey;

import com.marketlogicsoftware.cs.survey.models.Survey;
import com.marketlogicsoftware.cs.survey.models.SurveyDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class SurveyRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public String create(Survey survey) {
        return this.mongoTemplate
                .insert(new SurveyDocument(survey))
                .getId();
    }

    public Survey retrieve(String id) {
        return this.mongoTemplate.findById(id, SurveyDocument.class).getSurvey();
    }

    public void update(String id, Survey survey) {
        this.mongoTemplate.findAndModify(
                Query.query(Criteria.where("_id").is(id)),
                new Update().set("survey", survey),
                SurveyDocument.class
        );
    }

    public void delete(String id) {
        this.mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), SurveyDocument.class);
    }
}
