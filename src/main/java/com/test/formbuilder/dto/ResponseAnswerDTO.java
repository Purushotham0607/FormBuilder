package com.test.formbuilder.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.test.formbuilder.entity.Question;
import com.test.formbuilder.entity.Response;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAnswerDTO {
    private String id;
    private String answerText;
    private String questionId;
    private String selectedOptionId;
    private String responseId;
}
