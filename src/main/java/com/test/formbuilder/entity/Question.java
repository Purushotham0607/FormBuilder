package com.test.formbuilder.entity;



import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "questions", schema = "formbuilder_schema")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String controlType;
    private String label;
    private String dataType;
    private boolean required;

    @ManyToOne
    @JoinColumn(name = "form_id", nullable = false)
    private Form form;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<QuestionOption> options;
    @OneToOne(mappedBy="questions",cascade=CascadeType.ALL)//mapped to ResponseAnswer
    private ResponseAnswer responseAnswer;
}

