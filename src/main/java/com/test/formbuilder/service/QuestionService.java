package com.test.formbuilder.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.test.formbuilder.dto.QuestionDTO;

@Service
public interface QuestionService {
	   public QuestionDTO createQuestion(String id,QuestionDTO questionDTO);
	   public List<QuestionDTO> listExistingQuestions();
	   public QuestionDTO updateQuestion(String id, QuestionDTO questionDTO);
	   public void deleteQuestion(String  id);
}
