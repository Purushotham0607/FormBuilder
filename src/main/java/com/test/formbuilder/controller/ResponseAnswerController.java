package com.test.formbuilder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.formbuilder.dto.ResponseAnswerDTO;
import com.test.formbuilder.service.ResponseAnswerService;

@RestController
@RequestMapping("/api/response-answers")
public class ResponseAnswerController {
	@Autowired
	private ResponseAnswerService responseAnswerService;
    @PostMapping("/store/{responseid}/{questionid}/{selectedoptionid}")
    public ResponseEntity<ResponseAnswerDTO> storeAnswers(@RequestBody ResponseAnswerDTO responseAnswerDTO,@PathVariable("responseid") String respid,@PathVariable("questionid") String quesid,@PathVariable("selectedoptionid") String selectedoptid)
    {
    	return new ResponseEntity<>(responseAnswerService.storeAnswers(responseAnswerDTO,respid,quesid,selectedoptid),HttpStatus.OK);
    }
    @GetMapping("/fetch/{responseid}")
    public ResponseEntity<List<ResponseAnswerDTO>> fetchUsingResponseID(@PathVariable ("responseid") String id)
    {
    	return new ResponseEntity<>(responseAnswerService.fetchUsingResponseID(id),HttpStatus.FOUND);
    }
    @GetMapping("/fetchWithQuestionId/{questionid}")
    public ResponseEntity<List<ResponseAnswerDTO>> fetchUsingQuestionID(@PathVariable ("questionid") String id)
    {
    	return new ResponseEntity<>(responseAnswerService.fetchUsingQuestionID(id),HttpStatus.FOUND);
    }
    
}
