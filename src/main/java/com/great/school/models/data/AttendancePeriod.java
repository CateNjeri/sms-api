package com.great.school.models.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.event.spi.DeleteEventListener;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.sql.Time;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Entity
@Data

@NoArgsConstructor
@Table (name = "attendance_periods")
@EntityListeners({AuditingEntityListener.class})
public class AttendancePeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "from_time")
    private Time fromTime;
    @Column(name = "to_time")
    private Time toTime;
    @Column(name = "status")
    private int status;


    @Column(name = "created_at")
    @CreatedDate @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;
}
