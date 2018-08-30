package com.great.school.models.data;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
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
@Table(name = "user_accounts")
/*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")*/
public class UserAccount {
    public static final int USER_SCHOOL = 1;
    public static final int USER_PARENT = 2;
    public static final int USER_ADMIN = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "type")
    private int type;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", nullable = true)
    private String password;

    @NotEmpty
    @NotNull
    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "created_at")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

    @OneToOne(mappedBy = "userAccount", fetch = FetchType.EAGER)
    @JsonManagedReference("schoolUserAccount_userAccount")
    private SchoolUserAccount schoolUserAccount;

    @OneToMany(mappedBy = "userAccount", fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = "userAccount", allowSetters = true)
    private Set<Parent> parents;


    public String getPassword() {
        return password;
    }


    public String getUsername() {
        return username;
    }
}
