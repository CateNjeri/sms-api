package com.great.school.services.impl;

import com.great.school.models.data.School;
import com.great.school.repositories.SchoolRepository;
import com.great.school.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Service("schoolService")
@Transactional
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    SchoolRepository schoolRepository;

    @Override
    public School add(School school) {
        school.setEducationSystemLevel(school.getEducationSystemLevel());
        return schoolRepository.save(school);
    }

    @Override
    public void delete(long id) {
        schoolRepository.delete(id);
    }

    @Override
    public School update(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public School getById(long id) {
        return schoolRepository.findOne(id);
    }

    @Override
    public List<School> all() {
        return schoolRepository.findAll();
    }
}
