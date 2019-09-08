package com.marketlogicsoftware.cs;

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
public class ServiceDevConfiguration {
    @Autowired
    private ServiceProperties serviceProperties;

    @Bean
    public MongoClient mongoClient() throws IOException {
        return new EmbeddedMongoBuilder()
                .bindIp(serviceProperties.getDb().getHost())
                .build();
    }

    @Bean
    public MongoTemplate mongoTemplate() throws IOException {
        return new MongoTemplate(mongoClient(), serviceProperties.getDb().getName());
    }

}
