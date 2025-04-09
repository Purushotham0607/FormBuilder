package com.test.formbuilder.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.formbuilder.conversion.CustomIdGeneratorServiceForm;
import com.test.formbuilder.dto.FormDTO;
import com.test.formbuilder.entity.Form;
import com.test.formbuilder.repository.FormRepository;
import com.test.formbuilder.service.FormService;

@Service
public class FormServiceImpl implements FormService{

	@Autowired
	private FormRepository formRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CustomIdGeneratorServiceForm customIdGeneratorService;
	
	@Override
	public FormDTO createForm(FormDTO formDTO) {
		 Form form=modelMapper.map(formDTO,Form.class);
		 form.setId(customIdGeneratorService.generateNextId());
		 Form savedForm=formRepository.save(form);
		 
		 FormDTO updatedFormDTO= modelMapper.map(savedForm,FormDTO.class);
		 return updatedFormDTO;
	}

	@Override
	public List<FormDTO> listExistingForms() {
		List<Form> forms=formRepository.findAll();
		
		return forms.stream().map(
				form->modelMapper.map(form,FormDTO.class)
				).collect(Collectors.toList());
	}

	@Override
	public FormDTO updateForm(String id, FormDTO formDTO) {
		Form form=formRepository.findById(id).orElse(null);
		
		if(form!=null)
		{
			
			if(formDTO.getTitle()!=null)
			{
				form.setTitle(formDTO.getTitle());
			}
			if(formDTO.getDescription()!=null)
			{
				form.setDescription(formDTO.getDescription());
			}
			Form updatedForm=formRepository.save(form);
			return modelMapper.map(updatedForm,FormDTO.class);
		}
		return null;
		
}

	@Override
	public void  deleteForm(String id) {
		Form form=formRepository.findById(id).orElse(null);
		if(form!=null)
		{
			formRepository.deleteById(id);
		}
	}

	@Override
	public FormDTO detailsOfGivenId(String id) {
		Form form =formRepository.findById(id).orElse(null);
		if(form!=null)
		{
			return modelMapper.map(form, FormDTO.class);
			
		}
		return null;
	}
	



}
