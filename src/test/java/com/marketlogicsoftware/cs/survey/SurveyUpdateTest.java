package com.marketlogicsoftware.cs.survey;

import com.marketlogicsoftware.cs.survey.models.Survey;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyUpdateTest {
    @Autowired
    private WebTestClient webTestClient;

    @LocalServerPort
    private int randomPort;

    private List<URI> surveyURIs;
    private RestTemplate restTemplate = new RestTemplate();

    private Collection<Survey> surveys() {
        return Arrays.asList(
                new Survey("Java", "Java Survey")
        );
    }

    @Before
    public void setup() throws URISyntaxException {
        URI createSurveyURI = new URI("http://localhost:" + randomPort + "/api/survey");
        surveyURIs = new ArrayList<>();

        for (Survey survey : surveys()) {
            surveyURIs.add(restTemplate.postForLocation(createSurveyURI, survey));
        }
    }

    private void testUpdateSurvey(URI surveyURI) {
        webTestClient.put()
                     .uri(surveyURI)
                     .body(BodyInserters.fromObject(new Survey("Test Survey", "Test Survey Description")))
                     .exchange()
                     .expectStatus()
                     .isOk();
    }

    @Test
    public void testUpdateSurvey() {
        for (URI surveyURI : surveyURIs) {
            testUpdateSurvey(surveyURI);
        }
    }
}
