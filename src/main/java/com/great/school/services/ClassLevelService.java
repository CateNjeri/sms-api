package com.great.school.services;

import com.great.school.models.data.ClassLevel;

import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
public interface ClassLevelService extends BaseService<ClassLevel> {
    List<ClassLevel> findBySchoolId(long schoolId);
}
