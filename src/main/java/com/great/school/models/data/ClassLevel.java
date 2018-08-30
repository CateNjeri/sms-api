package com.great.school.models.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.util.Set;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Entity
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@EntityListeners({AuditingEntityListener.class})
@Table(name = "class_levels")
public class ClassLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @NotNull
    @Column(name = "name")
    private String name;

    @JoinColumn(name = "school_id")
    @ManyToOne
    @JsonIgnore
    private School school;

    @Column(name = "created_at")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

    @OneToMany(mappedBy = "classLevel")
    // @JsonBackReference("classLevelSection_classLevel")
    @JsonIgnore
    private Set<ClassLevelSection> classLevelSections;
}
