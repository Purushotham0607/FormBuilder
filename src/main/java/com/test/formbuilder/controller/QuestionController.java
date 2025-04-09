package com.test.formbuilder.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.formbuilder.dto.QuestionDTO;
import com.test.formbuilder.service.QuestionService;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	@PostMapping("/create/{form_id}")
	public ResponseEntity<QuestionDTO> createQuestion(@PathVariable("form_id") String id, @RequestBody QuestionDTO questionDTO){
		return new ResponseEntity<>(questionService.createQuestion(id, questionDTO),HttpStatus.CREATED);
	}
	 @GetMapping("/list") 
	  public ResponseEntity<List<QuestionDTO>>listExistingquestions(){
		 return new ResponseEntity<>(questionService.listExistingQuestions(),HttpStatus.OK);
	  
	  }
	 @PutMapping("/update/{id}")
	 public ResponseEntity<QuestionDTO> updateQuestion(@PathVariable String id, @RequestBody QuestionDTO questionDTO) {
	     return new ResponseEntity<>(questionService.updateQuestion(id, questionDTO), HttpStatus.OK);
	 }
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<Void> deleteQuestion(@PathVariable String id) {
		 questionService.deleteQuestion(id);
	     return new ResponseEntity<>(HttpStatus.OK);
	 }


}
