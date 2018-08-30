package com.great.school.services.impl;

import com.great.school.models.data.Assignment;
import com.great.school.repositories.AssignmentRepository;
import com.great.school.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Service("assignmentService")
@Transactional
public class AssignmentServiceImpl implements AssignmentService {
    @Autowired
    AssignmentRepository assignmentRepository;

    @Override
    public Assignment add(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public void delete(long id) {
        assignmentRepository.delete(id);
    }

    @Override
    public Assignment update(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public Assignment getById(long id) {
        return assignmentRepository.getOne(id);
    }

    @Override
    public List<Assignment> all() {
        return assignmentRepository.findAll();
    }
}
