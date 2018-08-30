package com.great.school.services.impl;

import com.great.school.models.data.SchoolUserAccount;
import com.great.school.models.data.UserAccount;
import com.great.school.models.request.LoginRequest;
import com.great.school.models.request.RegisterUserAccountRequest;
import com.great.school.repositories.UserAccountRepository;
import com.great.school.services.AuthenticationService;
import com.great.school.services.SchoolUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * Created by Kibet on 27-Nov-17.
 */
@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    SchoolUserAccountService schoolUserAccountService;

    @Override
    public Optional<UserAccount> login(LoginRequest loginRequest) {
        Optional<UserAccount> userAccountOptional = userAccountRepository
                .findByUsernameOrEmail(loginRequest.getUsername(), loginRequest.getUsername());
        return !userAccountOptional.isPresent() ?
                Optional.empty() :
                userAccountOptional.get().getPassword().equals(loginRequest.getPassword()) ? userAccountOptional :
                        Optional.empty();
    }

    @Override
    public Optional<UserAccount> register(UserAccount userAccount) {
        return Optional.of(userAccountRepository.save(userAccount));
    }


    @Override
    public SchoolUserAccount registerSchoolUserAccount(SchoolUserAccount schoolUserAccount) {
        // TODO: validate email here
        schoolUserAccount.getUserAccount().setType(UserAccount.USER_SCHOOL);
        schoolUserAccount.setRole(SchoolUserAccount.ROLE_ADMIN);
        schoolUserAccount = schoolUserAccountService.add(schoolUserAccount);

        return schoolUserAccount;
    }
}
