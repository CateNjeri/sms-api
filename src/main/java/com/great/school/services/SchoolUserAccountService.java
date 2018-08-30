package com.great.school.services;

import com.great.school.models.data.SchoolUserAccount;

import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
public interface SchoolUserAccountService extends BaseService<SchoolUserAccount> {
    List<SchoolUserAccount> findBySchoolId(long schoolId);
}
