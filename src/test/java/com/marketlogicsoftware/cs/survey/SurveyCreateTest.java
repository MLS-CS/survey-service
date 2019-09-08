package com.marketlogicsoftware.cs.survey;

import com.marketlogicsoftware.cs.survey.models.Survey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyCreateTest {
    @Autowired
    private WebTestClient webTestClient;

    private Collection<Survey> surveys() {
        return Arrays.asList(
                new Survey("Java", "Java Survey")
        );
    }

    private void testCreateSurvey(Survey survey) {
        webTestClient.post()
                     .uri("api/survey")
                     .body(BodyInserters.fromObject(survey))
                     .exchange()
                     .expectStatus()
                     .isCreated();
    }

    @Test
    public void testCreateSurvey() {
        for (Survey survey : surveys()) {
            testCreateSurvey(survey);
        }
    }
}
