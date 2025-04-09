package com.test.formbuilder.serviceImpl;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.formbuilder.conversion.CustomIdGeneratorServiceForm;
import com.test.formbuilder.conversion.CustomIdGeneratorServiceQuestionOption;
import com.test.formbuilder.dto.QuestionOptionDTO;
import com.test.formbuilder.entity.Question;
import com.test.formbuilder.entity.QuestionOption;
import com.test.formbuilder.repository.QuestionOptionRepository;
import com.test.formbuilder.repository.QuestionRepository;
import com.test.formbuilder.service.QuestionOptionService;
@Service
public class QuestionOptionServiceImpl implements QuestionOptionService {
    @Autowired
    private QuestionOptionRepository questionOptionRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
	private ModelMapper modelMapper;
    @Autowired
    private CustomIdGeneratorServiceQuestionOption customIdGeneratorService;
    @Override
    public QuestionOptionDTO createQuestionOption(QuestionOptionDTO questionOptionDTO, String questionId) {
        Question question = questionRepository.findById(questionId).orElse(null);
        QuestionOption questionOption = modelMapper.map(questionOptionDTO, QuestionOption.class);
        questionOption.setId(customIdGeneratorService.generateNextId());
        questionOption.setQuestion(question);
        questionOption = questionOptionRepository.save(questionOption);
        return modelMapper.map(questionOption, QuestionOptionDTO.class);
    }
    @Override
    public QuestionOptionDTO updateQuestionOption(String questionId, String id, QuestionOptionDTO questionOptionDTO) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(null);
        QuestionOption questionOption = questionOptionRepository.findById(id).orElse(null);
//        if (!questionOption.getQuestion().getId().equals(questionId)) {
//            throw new ResourceNotFoundException("Option does not belong to the given question.");
//        }
        questionOption.setOptionText(questionOptionDTO.getOptionText());
        questionOption = questionOptionRepository.save(questionOption);
        return modelMapper.map(questionOption, QuestionOptionDTO.class);
    }
    @Override
    public void deleteQuestionOption(String questionId, String id) {
        Question question = questionRepository.findById(questionId).orElse(null);

        QuestionOption questionOption = questionOptionRepository.findById(id).orElse(null);

//        if (!questionOption.getQuestion().getId().equals(questionId)) {
//            throw new ResourceNotFoundException("Option does not belong to the given question.");
//        }

        questionOptionRepository.delete(questionOption);
    }
}
