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

import com.test.formbuilder.dto.ResponseDTO;
import com.test.formbuilder.repository.ResponseRepository;
import com.test.formbuilder.service.ResponseService;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {
   @Autowired 
   private ResponseService responseService;
  @PostMapping("/create/{formid}")
  public ResponseEntity<ResponseDTO> createResponse(@RequestBody ResponseDTO responseDTO,@PathVariable ("formid") String id )
  {
	  return new ResponseEntity<>(responseService.createResponse(responseDTO,id),HttpStatus.CREATED);
  }
  @GetMapping("/list/{formid}")
  public ResponseEntity<List<ResponseDTO>> listResponse(@PathVariable ("formid") String id)
  {
	  return new ResponseEntity<>(responseService.listResponse(id),HttpStatus.OK);
  }
  
   
}
