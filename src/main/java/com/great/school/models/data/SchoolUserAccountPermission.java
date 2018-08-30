package com.great.school.models.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Kibet on 26-Nov-17.
 */
@EntityListeners(AuditingEntityListener.class)
@Entity
@Data
@NoArgsConstructor
@Table(name = "school_user_account_permissions")
public class SchoolUserAccountPermission {
    public static final int ROLE_ADMIN = 1;
    public static final int ROLE_TEACHER = 2;
    public static final int ROLE_CUSTOM = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "permission")
    private int permission;
    @Column(name = "has_permission")
    private boolean hasPermission;
    @Column(name = "created_at")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

    @JoinColumn(name = "school_user_account_id")
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference("schoolUserAccountPermissions")
    private SchoolUserAccount schoolUserAccount;

/*    @OneToOne(mappedBy = "schoolUserAccount")
    @JsonManagedReference("schoolUserAccount")
    private Teacher teacher;*/
}
