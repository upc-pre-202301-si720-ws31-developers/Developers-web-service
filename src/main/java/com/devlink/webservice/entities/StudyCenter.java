package com.devlink.webservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "study_center")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudyCenter implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

    @OneToMany(mappedBy = "studyCenter")
    private List<Education> educations;

    public StudyCenter(long l, String universityA, String cityA) {
    }
}
