package com.great.school.services;

import com.great.school.models.data.Teacher;

import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
public interface TeacherService extends BaseService<Teacher> {
    List<Teacher> findBySchoolId(long schoolId);
}
