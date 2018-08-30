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
@Data

@NoArgsConstructor
@EntityListeners({AuditingEntityListener.class})@Table (name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "others")
    private String others;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "stop_date")
    private Date stopDate;
    @ManyToOne
    @JoinColumn(name = "school")
    private School school;
    @Column(name = "is_bookable")
    private boolean isBookable;
    @Column(name = "in_noticeboard")
    private boolean inNoticeboard;

    @Column(name = "created_at")
    @CreatedDate @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private java.util.Date updatedAt;
}
