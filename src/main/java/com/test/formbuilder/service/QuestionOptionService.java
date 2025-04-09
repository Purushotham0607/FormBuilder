package com.test.formbuilder.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.test.formbuilder.dto.QuestionOptionDTO;
import com.test.formbuilder.entity.QuestionOption;

@Service
public interface QuestionOptionService{
	public QuestionOptionDTO createQuestionOption(QuestionOptionDTO questionOptionDTO,String questionId);
	public QuestionOptionDTO updateQuestionOption(String questionId, String id, QuestionOptionDTO questionOptionDTO);
	 void deleteQuestionOption(String questionId, String id);
}