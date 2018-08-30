package com.great.school.services.impl;

import com.great.school.models.data.SchoolUserAccount;
import com.great.school.models.data.UserAccount;
import com.great.school.repositories.SchoolUserAccountRepository;
import com.great.school.services.SchoolUserAccountService;
import com.great.school.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Service("schoolUserAccountService")
@Transactional
public class SchoolUserAccountServiceImpl implements SchoolUserAccountService {
    @Autowired
    SchoolUserAccountRepository schoolUserAccountRepository;

    @Autowired
    UserAccountService userAccountService;

    @Override
    public SchoolUserAccount add(SchoolUserAccount schoolUserAccount) {
        UserAccount userAccount = userAccountService.createOrFindSchoolUserAccount(schoolUserAccount);
        schoolUserAccount.setUserAccount(userAccount);
        schoolUserAccount = schoolUserAccountRepository.save(schoolUserAccount);
        //schoolUserAccount.getUserAccount().setSchoolUserAccount(schoolUserAccount);
        return schoolUserAccount;
    }

    @Override
    public void delete(long id) {
        schoolUserAccountRepository.delete(id);
    }

    @Override
    public SchoolUserAccount update(SchoolUserAccount schoolUserAccount) {
        return schoolUserAccountRepository.save(schoolUserAccount);
    }

    @Override
    public SchoolUserAccount getById(long id) {
        return schoolUserAccountRepository.getOne(id);
    }

    @Override
    public List<SchoolUserAccount> all() {
        return schoolUserAccountRepository.findAll();
    }

    @Override
    public List<SchoolUserAccount> findBySchoolId(long schoolId) {
        return all()
                .stream()
                .filter(schoolUserAccount -> schoolUserAccount.getSchool().getId() == schoolId)
                .collect(Collectors.toList());
    }
}
