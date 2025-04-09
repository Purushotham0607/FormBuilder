package com.test.formbuilder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "response_answers", schema = "formbuilder_schema")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAnswer {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String answerText;

    @ManyToOne //done
    @JoinColumn(name = "response_id", nullable = false)
    private Response response;

    @OneToOne//Question
    @JoinColumn(name = "question_id", nullable = false)
    private Question questions;

    @ManyToOne
    @JoinColumn(name = "selected_option_id")
    private QuestionOption selectedOption;
    
}
