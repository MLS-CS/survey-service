package com.marketlogicsoftware.cs.surveyservice.answer;

import com.marketlogicsoftware.cs.surveyservice.survey.models.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("survey/{surveyId}/question/{questionId}/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping()
    public ResponseEntity<?> createAnswer(@PathVariable("surveyId") String surveyId, @PathVariable("questionId") String questionId, @Valid @RequestBody Answer answer) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(answerService.createAnswer(surveyId, questionId, answer))
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retriveAnswer(@PathVariable("surveyId") String surveyId, @PathVariable("questionId") String questionId, @PathVariable("id") String id) {
        return ResponseEntity.ok(answerService.retrieveAnswer(surveyId, questionId, id));
    }

    @PutMapping("/{id}")
    public void updateAnswer(@PathVariable("surveyId") String surveyId, @PathVariable("questionId") String questionId, @PathVariable("id") String id, @Valid @RequestBody Answer answer) {
        answerService.updateAnswer(surveyId, questionId, id, answer);
    }

    @DeleteMapping("/{id}")
    public void deleteAnswer(@PathVariable("surveyId") String surveyId, @PathVariable("questionId") String questionId, @PathVariable("id") String id) {
        answerService.deleteAnswer(surveyId, questionId, id);
    }
}
