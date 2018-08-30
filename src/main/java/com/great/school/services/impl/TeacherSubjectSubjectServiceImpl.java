package com.great.school.services.impl;

import com.great.school.models.data.TeacherSubject;
import com.great.school.repositories.TeacherSubjectRepository;
import com.great.school.services.TeacherSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Service("teacherSubjectService")
@Transactional
public class TeacherSubjectSubjectServiceImpl implements TeacherSubjectService {
    @Autowired
    TeacherSubjectRepository teacherSubjectRepository;

    @Override
    public TeacherSubject add(TeacherSubject teacherSubject) {
        return teacherSubjectRepository.save(teacherSubject);
    }

    @Override
    public void delete(long id) {
        teacherSubjectRepository.delete(id);
    }

    @Override
    public TeacherSubject update(TeacherSubject teacherSubject) {
        return teacherSubjectRepository.save(teacherSubject);
    }

    @Override
    public TeacherSubject getById(long id) {
        return teacherSubjectRepository.getOne(id);
    }

    @Override
    public List<TeacherSubject> all() {
        return teacherSubjectRepository.findAll();
    }
}
