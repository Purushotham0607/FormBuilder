package com.test.formbuilder.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "forms", schema = "formbuilder_schema")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Form {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String title;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;	
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private String description;
    private String createdBy;
	  @OneToMany(mappedBy = "form", cascade = CascadeType.ALL) 
	  private List<Question> questions;
	 @OneToMany(mappedBy="forms",cascade=CascadeType.ALL) 
	 private List<Response> responses=new ArrayList<>();
	 
}
