package com.marketlogicsoftware.cs.surveyservice.survey;

import com.marketlogicsoftware.cs.surveyservice.survey.models.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("survey")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @PostMapping()
    public ResponseEntity<?> createSurvey(@Valid @RequestBody Survey survey) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(surveyService.createSurvey(survey))
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retriveSurvey(@PathVariable("id") String id) {
        return ResponseEntity.ok(surveyService.retrieveSurvey(id));
    }

    @PutMapping("/{id}")
    public void updateSurvey(@PathVariable("id") String id, @Valid @RequestBody Survey survey) {
        surveyService.updateSurvey(id, survey);
    }

    @DeleteMapping("/{id}")
    public void deleteSurvey(@PathVariable("id") String id) {
        surveyService.deleteSurvey(id);
    }
}
