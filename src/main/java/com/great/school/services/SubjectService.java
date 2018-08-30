package com.great.school.services;

import com.great.school.models.data.Subject;

import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
public interface SubjectService extends BaseService<Subject> {
    List<Subject> findBySchoolId(long schoolId);
}
