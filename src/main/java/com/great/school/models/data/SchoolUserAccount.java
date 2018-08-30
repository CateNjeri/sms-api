package com.great.school.models.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
 * Created by Kibet on 26-Nov-17.
 */
@EntityListeners(AuditingEntityListener.class)
@Entity
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Table(name = "school_user_accounts")
public class SchoolUserAccount {
    public static final int ROLE_ADMIN = 1;
    public static final int ROLE_TEACHER = 2;
    public static final int ROLE_CUSTOM = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "role")
    private int role;
    @Column(name = "status")
    private int status;
    @Column(name = "created_at")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

    @JoinColumn(name = "school_id")
    @ManyToOne
    // @JsonManagedReference("schoolUserAccount_School")
    private School school;

    @JoinColumn(name = "user_account_id")
    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference("schoolUserAccount_userAccount")
    private UserAccount userAccount;

    @OneToMany(mappedBy = "schoolUserAccount")
    @JsonManagedReference("schoolUserAccountPermissions")
    private Set<SchoolUserAccountPermission> schoolUserAccountPermissions;
/*    @OneToOne(mappedBy = "schoolUserAccount")
    @JsonManagedReference("schoolUserAccount")
    private Teacher teacher;*/
}
