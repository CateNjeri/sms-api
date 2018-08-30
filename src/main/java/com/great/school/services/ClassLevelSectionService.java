package com.great.school.services;

import com.great.school.models.data.ClassLevelSection;

import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
public interface ClassLevelSectionService extends BaseService<ClassLevelSection> {
    List<ClassLevelSection> findBySchoolId(long schoolId);
}
