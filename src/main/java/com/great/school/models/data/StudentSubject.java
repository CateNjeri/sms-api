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
@EntityListeners({AuditingEntityListener.class})@Table (name = "student_subjects")
public class StudentSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn(name = "student_id")
    @ManyToOne
    private Student student;
    @JoinColumn(name = "subject_id")
    @ManyToOne
    private Subject subject;
    @Column(name = "status")
    private int status;

    @Column(name = "created_at")
    @CreatedDate @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;
}
