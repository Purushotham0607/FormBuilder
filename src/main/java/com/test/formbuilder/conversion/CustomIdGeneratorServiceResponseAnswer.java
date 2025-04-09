package com.test.formbuilder.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.formbuilder.entity.ResponseAnswer;
import com.test.formbuilder.repository.ResponseAnswerRepository;

@Service
public class CustomIdGeneratorServiceResponseAnswer {
	@Autowired
    private ResponseAnswerRepository responseAnswerRepository;

    public String generateNextId() {
        String lastId = responseAnswerRepository.findTopByOrderByIdDesc()
                                      .map(ResponseAnswer::getId)
                                      .orElse("ID00000");
        int num = Integer.parseInt(lastId.substring(3));
        num++;
        return String.format("ID%05d", num);
    }
}

