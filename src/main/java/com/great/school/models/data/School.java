package com.great.school.models.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Data;
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
@EntityListeners({AuditingEntityListener.class})
@Table(name = "schools")
@Data

@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty
    @NotNull
    @Column(name = "name")
    private String name;
    @Column(name = "logo")
    private String logo;
    @Column(name = "address")
    private String address;
    @Column(name = "website")
    private String website;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "motto")
    private String motto;
    @Column(name = "vision")
    private String vision;
    @Column(name = "mission")
    private String mission;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "education_system_level_id")
    @JsonIgnoreProperties(value = "school", allowSetters = true)
    private EducationSystemLevel educationSystemLevel;

    @OneToMany
    @JsonIgnore
    /// @JsonBackReference("schoolUserAccount_School")
    private Set<SchoolUserAccount> schoolUserAccounts;


    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"school"})
    /// @JsonBackReference("schoolUserAccount_School")
    private Set<Student> students;

    @Column(name = "created_at")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;
}
