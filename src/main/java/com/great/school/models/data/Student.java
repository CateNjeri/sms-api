package com.great.school.models.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Entity
@EntityListeners({AuditingEntityListener.class})
@Table(name = "students")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @NotNull
    private String surname;

    @Column(name = "other_names")
    @NotEmpty
    @NotNull
    private String otherNames;
    @Column(name = "reg_no")

    @NotEmpty
    @NotNull
    private String regNo;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "admission_date")
    private Date admissionDate;

    @Column(name = "gender")
    private String gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "school_id")
    @JsonIgnoreProperties(value = {"students", "student"}, allowSetters = true)
    private School school;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    @JsonIgnoreProperties("students")
    private Parent parent;

    @OneToOne
    @JoinColumn(name = "class_level_section_id")
    // @JsonManagedReference("student_classLevelSection")
    private ClassLevelSection classLevelSection;

    @Column(name = "created_at")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;
}
