package com.great.school.services;

import com.great.school.models.data.Student;

import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
public interface StudentService extends BaseService<Student> {
    List<Student> findBySchoolId(long schoolId);

    List<Student> findByParentId(long parentId);

    List<Student> findByUserAccountId(long userAccountId);
}
