package com.great.school.models.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Entity
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@EntityListeners({AuditingEntityListener.class})
@Table(name = "class_level_sections")
public class ClassLevelSection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "teacher_id")
    @ManyToOne
    private Teacher teacher;

    @JoinColumn(name = "class_level_id")
    @ManyToOne
    // @JsonManagedReference("classLevelSection_classLevel")
    private ClassLevel classLevel;

    @Column(name = "created_at")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

    @OneToMany(mappedBy = "classLevelSection")
    @JsonIgnore
    // @JsonBackReference("student_classLevelSection")
    private Set<Student> students;
}
