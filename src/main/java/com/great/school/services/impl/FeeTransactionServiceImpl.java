package com.great.school.services.impl;

import com.great.school.models.data.FeeTransaction;
import com.great.school.repositories.FeeTransactionRepository;
import com.great.school.services.FeeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Service("feeTransactionService")
@Transactional
public class FeeTransactionServiceImpl implements FeeTransactionService {
    @Autowired
    FeeTransactionRepository feeTransactionRepository;

    @Override
    public FeeTransaction add(FeeTransaction feeTransaction) {
        return feeTransactionRepository.save(feeTransaction);
    }

    @Override
    public void delete(long id) {
        feeTransactionRepository.delete(id);
    }

    @Override
    public FeeTransaction update(FeeTransaction feeTransaction) {
        return feeTransactionRepository.save(feeTransaction);
    }

    @Override
    public FeeTransaction getById(long id) {
        return feeTransactionRepository.getOne(id);
    }

    @Override
    public List<FeeTransaction> all() {
        return feeTransactionRepository.findAll();
    }

    @Override
    public List<FeeTransaction> studentFeeTransactions(long studentId) {
        return feeTransactionRepository.findByStudentIdOrderById(studentId);
    }

    @Override
    public Optional<FeeTransaction> studentBalance(long studentId) {
        List<FeeTransaction> studentFeeTransactions = studentFeeTransactions(studentId);
        return studentFeeTransactions
                .isEmpty() ? Optional.empty() : Optional.of(studentFeeTransactions.get(0));
    }

    @Override
    public List<FeeTransaction> schoolTransactions(long schoolId) {
        return feeTransactionRepository.findByStudentSchoolId(schoolId);
    }
}
