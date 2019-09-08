package com.marketlogicsoftware.cs.surveyservice.answer;

import com.marketlogicsoftware.cs.surveyservice.survey.models.Answer;
import com.marketlogicsoftware.cs.surveyservice.survey.models.AnswerType;
import com.marketlogicsoftware.cs.surveyservice.survey.models.Question;
import com.marketlogicsoftware.cs.surveyservice.survey.models.Survey;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AnswerDeleteTest {

    @Autowired
    private WebTestClient webTestClient;

    @LocalServerPort
    private int randomPort;

    private List<URI> answerURIs;
    private RestTemplate restTemplate = new RestTemplate();

    private Collection<Answer> answers() {
        return Arrays.asList(
                new Answer("Yes"),
                new Answer("No")
        );
    }

    private void testDeleteAnswer(URI questionURI) {
        webTestClient.delete()
                     .uri(questionURI)
                     .exchange()
                     .expectStatus()
                     .isOk();
    }

    @Before
    public void setup() throws URISyntaxException {
        answerURIs = new ArrayList<>();

        URI surveyURI = restTemplate.postForLocation(
                new URI("http://localhost:" + randomPort + "/api/survey")
                , new Survey("Java", "Java Survey"));

        URI questionURI = restTemplate.postForLocation(
                surveyURI + "/question"
                , new Question("Is Java your favorite language", "Basics", AnswerType.Single));

        for (Answer answer : answers()) {
            answerURIs.add(
                    restTemplate.postForLocation(questionURI + "/answer", answer)
            );
        }
    }

    @Test
    public void testDeleteAnswer() {
        for (URI answerURI : answerURIs) {
            testDeleteAnswer(answerURI);
        }
    }
    
}
