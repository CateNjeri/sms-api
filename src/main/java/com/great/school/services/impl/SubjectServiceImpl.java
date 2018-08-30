package com.great.school.services.impl;

import com.great.school.models.data.SchoolUserAccount;
import com.great.school.models.data.Subject;
import com.great.school.models.data.UserAccount;
import com.great.school.repositories.SubjectRepository;
import com.great.school.services.SchoolUserAccountService;
import com.great.school.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Service("subjectService")
@Transactional
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectRepository subjectRepository;


    @Override
    public Subject add(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void delete(long id) {
        subjectRepository.delete(id);
    }

    @Override
    public Subject update(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject getById(long id) {
        return subjectRepository.getOne(id);
    }

    @Override
    public List<Subject> all() {
        return subjectRepository.findAll();
    }

    @Override
    public List<Subject> findBySchoolId(long schoolId) {
        return all()
                .stream()
                .filter(subject -> subject.getSchool() != null && subject.getSchool().getId() == schoolId)
                .collect(Collectors.toList());
    }
}
