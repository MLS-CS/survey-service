package com.marketlogicsoftware.cs.question;

import com.marketlogicsoftware.cs.survey.models.Survey;
import com.marketlogicsoftware.cs.survey.models.AnswerType;
import com.marketlogicsoftware.cs.survey.models.Question;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuestionCreateTest {
    @Autowired
    private WebTestClient webTestClient;

    @LocalServerPort
    private int randomPort;

    private URI surveyURI;
    private RestTemplate restTemplate = new RestTemplate();

    private Collection<Question> questions() {
        return Arrays.asList(
                new Question("Is Java your favorite language", "Basic", AnswerType.Single)
        );
    }

    private void testCreateQuestion(Question question) {
        webTestClient.post()
                     .uri(surveyURI + "/question")
                     .body(BodyInserters.fromObject(question))
                     .exchange()
                     .expectStatus()
                     .isCreated();
    }

    @Before
    public void setup() throws URISyntaxException {
        surveyURI = restTemplate.postForLocation(
                new URI("http://localhost:" + randomPort + "/api/survey")
                , new Survey("Java", "Java Survey"));
    }

    @Test
    public void testCreateQuestion() {
        for (Question question : questions()) {
            testCreateQuestion(question);
        }
    }
}
