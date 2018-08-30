package com.great.school.services;

import com.great.school.models.data.EducationSystemLevel;

import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
public interface EducationSystemLevelService extends BaseService<EducationSystemLevel> {
    public List<EducationSystemLevel> findByEducationSystemId(long educationSystemId);
}
