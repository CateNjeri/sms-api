package com.great.school.repositories;

import com.great.school.models.data.ClassLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Repository
public interface ClassLevelRepository extends JpaRepository<ClassLevel, Long> {
}
