package com.test.formbuilder.serviceImpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.formbuilder.conversion.CustomIdGeneratorServiceForm;
import com.test.formbuilder.conversion.CustomIdGeneratorServiceResponse;
import com.test.formbuilder.dto.ResponseDTO;
import com.test.formbuilder.entity.Form;
import com.test.formbuilder.entity.Response;
import com.test.formbuilder.repository.FormRepository;
import com.test.formbuilder.repository.ResponseRepository;
import com.test.formbuilder.service.ResponseService;

@Service
public class ResponseServiceImpl implements ResponseService {
	@Autowired 
	private ResponseRepository responseRepository;
	@Autowired
	private FormRepository formRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	CustomIdGeneratorServiceResponse customIdGeneratorService;
	@Override
	public ResponseDTO createResponse(ResponseDTO responseDTO, String id) {
		Form form = formRepository.findById(id).orElse(null);
		
		Response response=new Response();
		response.setUserId(responseDTO.getUserId());
		response.setId(customIdGeneratorService.generateNextId());
		response.setEmail(responseDTO.getEmail());
		response.setForms(form);
		Response savedResponse=responseRepository.save(response);
		ResponseDTO updatedResponseDTO=modelMapper.map(savedResponse, ResponseDTO.class);
		
		return updatedResponseDTO;
	}
	@Override
	public List<ResponseDTO> listResponse(String id) {
		//Form form=formRepository.findById(id).orElse(null);
		List<Response> response = responseRepository.findByFormsId(id);
		return response.stream().map(
				resp->modelMapper.map(resp,ResponseDTO.class )
				).collect(Collectors.toList());
	}
	
}
