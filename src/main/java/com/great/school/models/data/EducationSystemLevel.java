package com.great.school.models.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.util.Set;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@EntityListeners({AuditingEntityListener.class})
@Table(name = "education_system_levels")
public class EducationSystemLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @NotEmpty
    private String name;

    @JoinColumn(name = "education_system_id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "educationSystemLevels", allowSetters = true)
    private EducationSystem educationSystem;

    @OneToMany(mappedBy = "educationSystemLevel")
    // @JsonBackReference("school_educationSystemLevel")
    // @JsonIgnoreProperties(value = {"educationSystemLevel"}, allowSetters = true)
    @JsonIgnore
    private Set<School> schools;

    @Column(name = "created_at")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

}
