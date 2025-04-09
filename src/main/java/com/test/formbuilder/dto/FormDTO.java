package com.test.formbuilder.dto;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class FormDTO {
    private String id;
    private String title;
    private String description;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt; 
    //private List<QuestionDTO> questions;
}
