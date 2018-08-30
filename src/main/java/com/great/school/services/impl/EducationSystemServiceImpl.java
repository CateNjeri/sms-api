package com.great.school.services.impl;

import com.great.school.models.data.EducationSystem;
import com.great.school.repositories.EducationSystemRepository;
import com.great.school.services.EducationSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Service("educationSystemService")
@Transactional
public class EducationSystemServiceImpl implements EducationSystemService {
    @Autowired
    EducationSystemRepository educationSystemRepository;

    @Override
    public EducationSystem add(EducationSystem educationSystem) {
        return educationSystemRepository.save(educationSystem);
    }

    @Override
    public void delete(long id) {
        educationSystemRepository.delete(id);
    }

    @Override
    public EducationSystem update(EducationSystem educationSystem) {
        return educationSystemRepository.save(educationSystem);
    }

    @Override
    public EducationSystem getById(long id) {
        return educationSystemRepository.findOne(id);
    }

    @Override
    public List<EducationSystem> all() {
        return educationSystemRepository.findAll();
    }
}
