package com.marketlogicsoftware.cs.surveyservice;

import com.mongodb.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

@Configuration
@Profile("dev")
public class SurveyServiceDevConfiguration {
    @Autowired
    private SurveyServiceProperties surveyServiceProperties;

    @Bean
    public MongoClient mongoClient() throws IOException {
        return new EmbeddedMongoBuilder()
                .bindIp(surveyServiceProperties.getDb().getHost())
                .build();
    }

    @Bean
    public MongoTemplate mongoTemplate() throws IOException {
        return new MongoTemplate(mongoClient(), surveyServiceProperties.getDb().getName());
    }

}
