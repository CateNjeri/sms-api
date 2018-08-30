package com.great.school.repositories;

import com.great.school.models.data.FeeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Repository
public interface FeeTransactionRepository extends JpaRepository<FeeTransaction, Long> {
    List<FeeTransaction> findByStudentIdOrderById(long studentId);

    List<FeeTransaction> findByStudentSchoolId(long schoolId);
}
