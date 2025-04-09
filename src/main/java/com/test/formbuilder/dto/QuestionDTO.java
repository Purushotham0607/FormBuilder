package com.test.formbuilder.dto;

import lombok.*;
import java.util.List;

@Data
@Getter
@Setter
public class QuestionDTO {
    private String id;
    private String controlType;
    private String label;
    private String dataType;
    private boolean required;
    private String formId;
    //private List<QuestionOptionDTO> options;
}
