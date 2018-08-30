package com.great.school.repositories;

import com.great.school.models.data.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
    List<Parent> findAllByUserAccountIdAndUserAccountNotNull(long userAccountId);
}
