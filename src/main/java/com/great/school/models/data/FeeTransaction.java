package com.great.school.models.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Kibet on 26-Nov-17.
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "fee_transactions")
@EntityListeners({AuditingEntityListener.class})
public class FeeTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private BigDecimal amount;

    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "school_session_id")
    private SchoolSession schoolSession;

    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "payment_method")
    private int paymentMethod;

    @Column(name = "created_at")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

}
