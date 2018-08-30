package com.great.school.services.impl;

import com.great.school.models.data.Parent;
import com.great.school.models.data.Student;
import com.great.school.repositories.ParentRepository;
import com.great.school.services.ParentService;
import com.great.school.services.StudentService;
import com.great.school.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Service("parentService")
@Transactional
public class ParentServiceImpl implements ParentService {
    @Autowired
    ParentRepository parentRepository;

    @Autowired
    StudentService studentService;


    @Autowired
    UserAccountService userAccountService;

    @Override
    public Parent add(Parent parent) {
        // parent.getUserAccount()
        parent.setUserAccount(userAccountService.createOrFindParentUserAccount(parent));
        return parentRepository.save(parent);
    }

    @Override
    public void delete(long id) {
        parentRepository.delete(id);
    }

    @Override
    public Parent update(Parent parent) {
        parent.setUserAccount(userAccountService.createOrFindParentUserAccount(parent));
        return parentRepository.save(parent);
    }

    @Override
    public Parent getById(long id) {
        return parentRepository.getOne(id);
    }

    @Override
    public List<Parent> all() {
        return parentRepository.findAll();
    }

    @Override
    public List<Parent> findInSchool(long schoolId) {
        return all().stream()
                .filter(parent -> findStudents(parent.getId())
                        .stream().anyMatch(student -> student.getSchool().getId() == schoolId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> findStudents(long id) {
        //return new ArrayList<>(parentRepository.findOne(id).getStudents());
        return studentService.findByParentId(id);
    }

    @Override
    public List<Parent> findByUserAccountId(long userAccountId) {
        return parentRepository.findAllByUserAccountIdAndUserAccountNotNull(userAccountId);
    }
}
