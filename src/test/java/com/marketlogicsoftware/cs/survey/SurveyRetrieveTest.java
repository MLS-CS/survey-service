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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyRetrieveTest {

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

    private void testRetrieveSurvey(URI surveyURI) {
        webTestClient.get()
                     .uri(surveyURI)
                     .exchange()
                     .expectStatus()
                     .isOk();
    }

    @Before
    public void setup() throws URISyntaxException {
        URI createSurveyURI = new URI("http://localhost:" + randomPort + "/api/survey");
        surveyURIs = new ArrayList<>();

        for (Survey survey : surveys()) {
            surveyURIs.add(restTemplate.postForLocation(createSurveyURI, survey));
        }
    }

    @Test
    public void testRetrieveSurvey() {
        for (URI surveyURI : surveyURIs) {
            testRetrieveSurvey(surveyURI);
        }
    }

}
