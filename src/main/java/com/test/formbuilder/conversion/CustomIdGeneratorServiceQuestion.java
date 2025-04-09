package com.test.formbuilder.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.formbuilder.entity.Question;
import com.test.formbuilder.repository.QuestionRepository;

@Service
public class CustomIdGeneratorServiceQuestion {
	@Autowired
    private QuestionRepository questionRepository;

    public String generateNextId() {
        String lastId = questionRepository.findTopByOrderByIdDesc()
                                      .map(Question::getId)
                                      .orElse("ID00000");
        int num = Integer.parseInt(lastId.substring(3));
        num++;
        return String.format("ID%05d", num);
}
}

