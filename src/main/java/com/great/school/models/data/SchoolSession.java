package com.great.school.models.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Entity
@EntityListeners({AuditingEntityListener.class})@Table (name = "school_sessions")
@Data

@NoArgsConstructor
public class SchoolSession extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Date start;
    private Date end;
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
    private int status;

    @Column(name = "created_at")
    @CreatedDate @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

}
