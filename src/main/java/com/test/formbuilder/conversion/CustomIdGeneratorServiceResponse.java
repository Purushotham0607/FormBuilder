package com.test.formbuilder.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.formbuilder.entity.Response;
import com.test.formbuilder.repository.ResponseRepository;

@Service
public class CustomIdGeneratorServiceResponse {
	 @Autowired
	    private ResponseRepository responeRepository;

	    public String generateNextId() {
	        String lastId = responeRepository.findTopByOrderByIdDesc()
	                                      .map(Response::getId)
	                                      .orElse("ID00000");
	        int num = Integer.parseInt(lastId.substring(3));
	        num++;
	        return String.format("ID%05d", num);
	    }
}



