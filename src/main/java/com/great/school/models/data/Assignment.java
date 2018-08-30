package com.great.school.models.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Entity
@Data

@NoArgsConstructor
@EntityListeners({AuditingEntityListener.class})@Table (name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "class_level_section_subject_teacher_id")
    private ClassLevelSectionSubjectTeacher classLevelSectionSubjectTeacher;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private int status;

    @Column(name = "created_at")
    @CreatedDate @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

}