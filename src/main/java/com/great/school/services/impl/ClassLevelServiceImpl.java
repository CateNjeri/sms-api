package com.great.school.services.impl;

import com.great.school.models.data.ClassLevel;
import com.great.school.repositories.ClassLevelRepository;
import com.great.school.services.ClassLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Service("classLevelService")
@Transactional
public class ClassLevelServiceImpl implements ClassLevelService {
    @Autowired
    ClassLevelRepository classLevelRepository;

    @Override
    public ClassLevel add(ClassLevel classLevel) {
        return classLevelRepository.save(classLevel);
    }

    @Override
    public void delete(long id) {
        classLevelRepository.delete(id);
    }

    @Override
    public ClassLevel update(ClassLevel classLevel) {
        return classLevelRepository.save(classLevel);
    }

    @Override
    public ClassLevel getById(long id) {
        return classLevelRepository.findOne(id);
    }

    @Override
    public List<ClassLevel> all() {
        return classLevelRepository.findAll();
    }

    @Override
    public List<ClassLevel> findBySchoolId(long schoolId) {
        return all()
                .stream()
                .filter(classLevel -> classLevel.getSchool() != null && classLevel.getSchool().getId() == schoolId)
                .collect(Collectors.toList());
    }
}
