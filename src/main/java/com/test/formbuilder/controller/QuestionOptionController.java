package com.test.formbuilder.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.test.formbuilder.dto.QuestionOptionDTO;
import com.test.formbuilder.entity.QuestionOption;
import com.test.formbuilder.service.QuestionOptionService;
@RestController
@RequestMapping("/api/question-options")
public class QuestionOptionController {
	@Autowired
    private QuestionOptionService questionOptionService;
	@PostMapping("/create/{questionId}")
	public ResponseEntity<QuestionOptionDTO> createQuestionOptions(@RequestBody QuestionOptionDTO questionOptionDTO ,@PathVariable String questionId)
	{
		return new ResponseEntity<>(questionOptionService.createQuestionOption(questionOptionDTO,questionId),HttpStatus.CREATED);
	}
	@PutMapping("/update/{questionId}/{id}")
    public ResponseEntity<QuestionOptionDTO> updateQuestionOptions(@PathVariable String questionId, 
                                                                   @PathVariable String id, 
                                                                   @RequestBody QuestionOptionDTO questionOptionDTO) {
        return new ResponseEntity<>(questionOptionService.updateQuestionOption(questionId, id, questionOptionDTO),HttpStatus.OK);
    }
	@DeleteMapping("/delete/{questionId}/{id}")
    public ResponseEntity<String> deleteQuestionOption(@PathVariable String questionId, @PathVariable String id) {
        questionOptionService.deleteQuestionOption(questionId, id);
        return new ResponseEntity<>(("Option with ID " + id + " deleted successfully."),HttpStatus.OK);
    }
}
