package com.test.formbuilder.serviceImpl;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.formbuilder.conversion.CustomIdGeneratorServiceForm;
import com.test.formbuilder.conversion.CustomIdGeneratorServiceQuestion;
import com.test.formbuilder.dto.QuestionDTO;
import com.test.formbuilder.entity.Form;
import com.test.formbuilder.entity.Question;
import com.test.formbuilder.repository.FormRepository;
import com.test.formbuilder.repository.QuestionRepository;
import com.test.formbuilder.service.QuestionService;
@Service
public class QuestionSeviceImpl implements QuestionService{
		
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private FormRepository formRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CustomIdGeneratorServiceQuestion customIdGeneratorService;

	@Override
	public QuestionDTO createQuestion(String id, QuestionDTO questionDTO) {
		     Form forms=formRepository.findById(id).orElse(null);
			 Question question=modelMapper.map(questionDTO,Question.class);
			 question.setForm(forms);
			 question.setId(customIdGeneratorService.generateNextId());
			 Question savedQuestion=questionRepository.save(question);
			 
			 QuestionDTO updatedQuestionDTO= modelMapper.map(savedQuestion,QuestionDTO.class);
			 return updatedQuestionDTO;
	}

	@Override
	public List<QuestionDTO> listExistingQuestions() {
		List<Question> question=questionRepository.findAll();
		
		return question.stream().map(
				quest->modelMapper.map(quest, QuestionDTO.class)
				).collect(Collectors.toList());
				
	}
	@Override
	public QuestionDTO updateQuestion(String id, QuestionDTO questionDTO) {
	    Question existingQuestion = questionRepository.findById(id)
	            .orElse(null);

	    // Update only non-null fields
	    if (questionDTO.getControlType() != null) {
	        existingQuestion.setControlType(questionDTO.getControlType());
	    }
	    if (questionDTO.getLabel() != null) {
	        existingQuestion.setLabel(questionDTO.getLabel());
	    }
	    if (questionDTO.getDataType() != null) {
	        existingQuestion.setDataType(questionDTO.getDataType());
	    }
	    // Check if the 'required' field is present in DTO
	    if (questionDTO.isRequired() != existingQuestion.isRequired()) { 
	        existingQuestion.setRequired(questionDTO.isRequired());
	    }

	    Question updatedQuestion = questionRepository.save(existingQuestion);
	    return modelMapper.map(updatedQuestion, QuestionDTO.class);
	}

	@Override
	public void deleteQuestion(String id) {
		Question question=questionRepository.findById(id).orElse(null);
		if(question!=null)
		{
			questionRepository.deleteById(id);
			
		}
	}
	
}


