package com.great.school.models.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "parents")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "surname")
    private String surname;
    @Column(name = "other_names")
    private String otherNames;
    @Column(name = "id_number")
    private String idNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parent")
    @JsonIgnoreProperties("parent")
    // @JsonBackReference("studentParent")
    private Set<Student> students;

    @Column(name = "created_at")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // @JsonManagedReference("parentAccount_userAccount")
    @JoinColumn(name = "user_account_id")
    //@JsonBackReference("parent_UserAccounts")
    // @JsonIgnoreProperties("parents")
    @JsonIgnoreProperties(value = "parents",allowSetters = true)
    private UserAccount userAccount;

}
