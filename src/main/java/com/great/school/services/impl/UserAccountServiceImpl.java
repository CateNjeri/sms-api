package com.great.school.services.impl;

import com.great.school.models.data.Parent;
import com.great.school.models.data.SchoolUserAccount;
import com.great.school.models.data.UserAccount;
import com.great.school.repositories.UserAccountRepository;
import com.great.school.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Service("userAccountService")
@Transactional
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public UserAccount add(UserAccount userAccount) {
        Optional<UserAccount> accountExists = findSchoolUserAccountByEmail(userAccount.getEmail());
        //TODO:  Validates. Should throw an error though
        return accountExists.orElseGet(() -> userAccountRepository.save(userAccount));
    }

    @Override
    public void delete(long id) {
        userAccountRepository.delete(id);
    }

    @Override
    public UserAccount update(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount getById(long id) {
        return userAccountRepository.getOne(id);
    }

    @Override
    public List<UserAccount> all() {
        return userAccountRepository.findAll();
    }

    @Override
    public Optional<UserAccount> findParentUserAccountByEmail(String email) {
        return userAccountRepository.findByEmailAndType(email, UserAccount.USER_PARENT);
    }

    @Override
    public String generateRandomPassword() {
        return "password";
    }

    @Override
    public UserAccount createOrFindParentUserAccount(Parent parent) {
        Optional<UserAccount> parentUserAccount = this.findParentUserAccountByEmail(parent.getEmail());

        if (parentUserAccount.isPresent()) {
            // Don't create account, update instead
            return parentUserAccount.get();
        } else {
            UserAccount userAccount = new UserAccount();
            //Create account with default credentials and send an email to the parent

            userAccount.setEmail(parent.getEmail());
            userAccount.setType(UserAccount.USER_PARENT);
            userAccount.setPassword(this.generateRandomPassword());
            userAccount.setUsername(parent.getIdNumber());

            this.add(userAccount);

            // TODO: Send email
            return userAccount;
        }
    }
    @Override
    public UserAccount createOrFindSchoolUserAccount(SchoolUserAccount schoolUserAccount) {
        Optional<UserAccount> userAccountOptional =
                this.findSchoolUserAccountByEmail(schoolUserAccount.getUserAccount().getEmail());

        // Don't create account, update instead
        // TODO: Send email
        return userAccountOptional.orElseGet(() -> this.add(schoolUserAccount.getUserAccount()));
    }

    @Override
    public Optional<UserAccount> findSchoolUserAccountByEmail(String email) {
        return userAccountRepository.findByEmailAndType(email, UserAccount.USER_SCHOOL);
    }
}
