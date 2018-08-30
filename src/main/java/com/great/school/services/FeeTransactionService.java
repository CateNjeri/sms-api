package com.great.school.services;

import com.great.school.models.data.FeeTransaction;

import java.util.List;
import java.util.Optional;

/**
 * Created by Kibet on 25-Nov-17.
 */
public interface FeeTransactionService extends BaseService<FeeTransaction> {
    List<FeeTransaction> studentFeeTransactions(long studentId);

    Optional<FeeTransaction> studentBalance(long studentId);

    List<FeeTransaction> schoolTransactions(long schoolId);
}
