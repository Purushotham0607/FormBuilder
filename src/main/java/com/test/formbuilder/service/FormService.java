package com.test.formbuilder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.formbuilder.dto.FormDTO;

@Service
public interface FormService {
   public FormDTO createForm(FormDTO formDTO);
   public List<FormDTO> listExistingForms();
   public FormDTO updateForm(String id,FormDTO formDTO);
   public void deleteForm(String id);
   public FormDTO detailsOfGivenId(String id);
}
