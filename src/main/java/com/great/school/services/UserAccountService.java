package com.great.school.services;

import com.great.school.models.data.Parent;
import com.great.school.models.data.SchoolUserAccount;
import com.great.school.models.data.UserAccount;

import java.util.Optional;

/**
 * Created by Kibet on 25-Nov-17.
 */
public interface UserAccountService extends BaseService<UserAccount> {
    Optional<UserAccount> findParentUserAccountByEmail(String email);

    String generateRandomPassword();

    UserAccount createOrFindParentUserAccount(Parent parent);

    UserAccount createOrFindSchoolUserAccount(SchoolUserAccount schoolUserAccount);

    Optional<UserAccount> findSchoolUserAccountByEmail(String email);

}
