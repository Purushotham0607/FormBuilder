package com.test.formbuilder.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.formbuilder.entity.QuestionOption;
import com.test.formbuilder.repository.QuestionOptionRepository;

@Service
public class CustomIdGeneratorServiceQuestionOption {
	@Autowired
    private QuestionOptionRepository questionOptionRepository;

    public String generateNextId() {
        String lastId = questionOptionRepository.findTopByOrderByIdDesc()
                                      .map(QuestionOption::getId)
                                      .orElse("ID-00000");
        int num = Integer.parseInt(lastId.substring(3));
        num++;
        return String.format("ID%05d", num);
    }
}

