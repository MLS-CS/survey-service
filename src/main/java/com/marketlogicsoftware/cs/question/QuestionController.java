package com.marketlogicsoftware.cs.question;

import com.marketlogicsoftware.cs.survey.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("survey/{surveyId}/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping()
    public ResponseEntity<?> createQuestion(@PathVariable("surveyId") String surveyId, @Valid @RequestBody Question question) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(questionService.createQuestion(surveyId, question))
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retriveQuestion(@PathVariable("surveyId") String surveyId, @PathVariable("id") String id) {
        return ResponseEntity.ok(questionService.retrieveQuestion(surveyId, id));
    }

    @PutMapping("/{id}")
    public void updateQuestion(@PathVariable("surveyId") String surveyId, @PathVariable("id") String id, @Valid @RequestBody Question question) {
        questionService.updateQuestion(surveyId, id, question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable("surveyId") String surveyId, @PathVariable("id") String id) {
        questionService.deleteQuestion(surveyId, id);
    }
}
