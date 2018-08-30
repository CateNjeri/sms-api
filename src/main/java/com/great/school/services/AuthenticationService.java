package com.great.school.services;

import com.great.school.models.data.SchoolUserAccount;
import com.great.school.models.data.UserAccount;
import com.great.school.models.request.LoginRequest;
import com.great.school.models.request.RegisterUserAccountRequest;

import java.util.Optional;

/**
 * Created by Kibet on 27-Nov-17.
 */

public interface AuthenticationService {
    public Optional<UserAccount> login(LoginRequest loginRequest);

    Optional<UserAccount> register(UserAccount userAccount);

    SchoolUserAccount registerSchoolUserAccount(SchoolUserAccount schoolUserAccount);
}
