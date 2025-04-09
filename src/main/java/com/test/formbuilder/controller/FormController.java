package com.test.formbuilder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.formbuilder.dto.FormDTO;
import com.test.formbuilder.service.FormService;

@RestController
@RequestMapping("/api/forms")
public class FormController {
	
	@Autowired
    private FormService formService;
	
   @PostMapping("/create")
   public ResponseEntity<FormDTO> createForm(@RequestBody FormDTO formDTO)
   {
	   return new ResponseEntity<>(formService.createForm(formDTO),HttpStatus.CREATED);
   }
   @GetMapping("/list")
   public ResponseEntity<List<FormDTO>> listExistingForms()
   {
	   return new ResponseEntity<> (formService.listExistingForms(),HttpStatus.OK); 
   
   }
   @PutMapping("update/{formid}")
   public ResponseEntity<FormDTO> updateForm(@PathVariable ("formid") String id,@RequestBody FormDTO formDTO)
   {
	   return new ResponseEntity<>(formService.updateForm(id,formDTO),HttpStatus.OK);
   }
   @DeleteMapping("/{userid}/delete")
   public ResponseEntity<Void> deleteForm(@PathVariable ("userid") String id)
   {
	   formService.deleteForm(id);
	   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	   
	   
   }
   @GetMapping("{userid}/detailsUsingId")
   public ResponseEntity<FormDTO> detailsOfGivenId(@PathVariable ("userid") String id)
   {
	   return new ResponseEntity<>(formService.detailsOfGivenId(id),HttpStatus.OK);
   }
   
}