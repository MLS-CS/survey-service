package com.marketlogicsoftware.cs.surveyservice;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

@Configuration
@Profile("prod")
public class SurveyServiceProdConfiguration {
    @Autowired
    private SurveyServiceProperties surveyServiceProperties;

    @Bean
    public MongoClient mongoClient() throws IOException {
        return new MongoClient(
                surveyServiceProperties.getDb().getHost(),
                surveyServiceProperties.getDb().getPort());
    }

    @Bean
    public MongoTemplate mongoTemplate() throws IOException {
        return new MongoTemplate(mongoClient(), surveyServiceProperties.getDb().getName());
    }

}
