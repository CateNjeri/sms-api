package com.great.school.services.impl;

;
import com.great.school.models.data.EducationSystemLevel;
import com.great.school.repositories.EducationSystemLevelRepository;
import com.great.school.services.EducationSystemLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Service("educationSystemLevelService")
@Transactional
public class EducationSystemLevelServiceImpl implements EducationSystemLevelService {
    @Autowired
    EducationSystemLevelRepository educationSystemLevelRepository;

    @Override
    public EducationSystemLevel add(EducationSystemLevel educationSystemLevel) {
        return educationSystemLevelRepository.save(educationSystemLevel);
    }

    @Override
    public void delete(long id) {
        educationSystemLevelRepository.delete(id);
    }

    @Override
    public EducationSystemLevel update(EducationSystemLevel educationSystemLevel) {
        return educationSystemLevelRepository.save(educationSystemLevel);
    }

    @Override
    public EducationSystemLevel getById(long id) {
        return educationSystemLevelRepository.getOne(id);
    }

    @Override
    public List<EducationSystemLevel> all() {
        return educationSystemLevelRepository.findAll();
    }

    @Override
    public List<EducationSystemLevel> findByEducationSystemId(long educationSystemId) {
        return all()
                .stream()
                .filter(educationSystemLevel -> educationSystemLevel.getEducationSystem().getId() == educationSystemId)
                .collect(Collectors.toList());
    }
}
