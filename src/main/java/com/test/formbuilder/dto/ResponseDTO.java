package com.test.formbuilder.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

import com.test.formbuilder.entity.Form;

@Data
@Getter
@Setter
public class ResponseDTO {
    private String id;
    private String userId;
    private String email;
    private LocalDateTime submittedAt;
    //private List<ResponseAnswerDTO> answers;
}
