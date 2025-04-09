package com.test.formbuilder.entity;


import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "question_options", schema = "formbuilder_schema")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionOption {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String optionText;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
    @OneToMany(mappedBy="selectedOption",cascade=CascadeType.ALL)
    private List<ResponseAnswer> responseAnswers;
}
