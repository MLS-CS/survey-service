package com.marketlogicsoftware.cs;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

@Configuration
@Profile("prod")
public class ServiceProdConfiguration {
    @Autowired
    private ServiceProperties serviceProperties;

    @Bean
    public MongoClient mongoClient() throws IOException {
        return new MongoClient(
                serviceProperties.getDb().getHost(),
                serviceProperties.getDb().getPort());
    }

    @Bean
    public MongoTemplate mongoTemplate() throws IOException {
        return new MongoTemplate(mongoClient(), serviceProperties.getDb().getName());
    }

}
