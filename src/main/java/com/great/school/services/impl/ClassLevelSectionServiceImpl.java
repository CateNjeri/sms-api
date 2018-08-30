package com.great.school.services.impl;

import com.great.school.models.data.ClassLevelSection;
import com.great.school.repositories.ClassLevelSectionRepository;
import com.great.school.services.ClassLevelSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Service("classLevelSectionService")
@Transactional
public class ClassLevelSectionServiceImpl implements ClassLevelSectionService {
    @Autowired
    ClassLevelSectionRepository classLevelSectionRepository;

    @Override
    public ClassLevelSection add(ClassLevelSection classLevelSection) {
        return classLevelSectionRepository.save(classLevelSection);
    }

    @Override
    public void delete(long id) {
        classLevelSectionRepository.delete(id);
    }

    @Override
    public ClassLevelSection update(ClassLevelSection classLevelSection) {
        return classLevelSectionRepository.save(classLevelSection);
    }

    @Override
    public ClassLevelSection getById(long id) {
        return classLevelSectionRepository.getOne(id);
    }

    @Override
    public List<ClassLevelSection> all() {
        return classLevelSectionRepository.findAll();
    }

    @Override
    public List<ClassLevelSection> findBySchoolId(long schoolId) {
        return all()
                .stream()
                .filter(classLevel -> classLevel.getClassLevel() != null && classLevel.getClassLevel().getSchool() != null && classLevel.getClassLevel().getSchool().getId() == schoolId)
                .collect(Collectors.toList());
    }
}
