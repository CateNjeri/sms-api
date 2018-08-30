package com.great.school.models.data;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
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
import java.util.List;
import java.util.Set;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Entity
@Data()
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@EntityListeners({AuditingEntityListener.class})
@Table(name = "education_systems")
public class EducationSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @NotEmpty
    private String name;
    @Column(name = "created_at")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

    @OneToMany(mappedBy = "educationSystem", fetch = FetchType.EAGER)
    // @JsonBackReference("educationSystemLevel_educationSystem")
    @JsonIgnoreProperties(value = "educationSystem", allowSetters = true)
    private Set<EducationSystemLevel> educationSystemLevels;

}
