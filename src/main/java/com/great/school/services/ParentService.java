package com.great.school.services;

import com.great.school.models.data.Parent;
import com.great.school.models.data.Student;

import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
public interface ParentService extends BaseService<Parent> {
    List<Parent> findInSchool(long schoolId);

    List<Student> findStudents(long id);

    List<Parent> findByUserAccountId(long userAccountId);
}
