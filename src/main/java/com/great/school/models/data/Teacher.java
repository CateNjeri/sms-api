package com.great.school.models.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.validator.constraints.Email;
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
@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "surname")
    private String surname;
    @Column(name = "other_names")
    private String otherNames;
    @Column(name = "code")
    private String code;
    @Column(name = "email")
    @Email
    private String email;
    @ManyToOne
    @JoinColumn(name = "school_id")
    // @JsonManagedReference("school")
    private School school;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_user_account_id")
    @JsonBackReference("schoolUserAccount")
    private SchoolUserAccount schoolUserAccount;

    @Column(name = "created_at")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

}
