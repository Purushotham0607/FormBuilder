package com.test.formbuilder.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "responses", schema = "formbuilder_schema")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String userId;
    private String email;
    @CreationTimestamp
    private LocalDateTime submittedAt;

    @ManyToOne
    @JoinColumn(name = "form_id", nullable = false)//done
    private Form forms;

    @OneToMany(mappedBy = "response", cascade = CascadeType.ALL)//done
    private List<ResponseAnswer> answers;
    
    
    
}

