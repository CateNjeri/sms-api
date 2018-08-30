package com.great.school.services.impl;

import com.great.school.models.data.SchoolUserAccount;
import com.great.school.models.data.Teacher;
import com.great.school.models.data.UserAccount;
import com.great.school.repositories.TeacherRepository;
import com.great.school.services.SchoolUserAccountService;
import com.great.school.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    SchoolUserAccountService schoolUserAccountService;

    @Override
    public Teacher add(Teacher teacher) {
        teacher.getSchoolUserAccount().setRole(SchoolUserAccount.ROLE_TEACHER);
        teacher.getSchoolUserAccount().getUserAccount().setType(UserAccount.USER_SCHOOL);
        schoolUserAccountService.add(teacher.getSchoolUserAccount());
        return teacherRepository.save(teacher);
    }

    @Override
    public void delete(long id) {
        teacherRepository.delete(id);
    }

    @Override
    public Teacher update(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher getById(long id) {
        return teacherRepository.getOne(id);
    }

    @Override
    public List<Teacher> all() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Teacher> findBySchoolId(long schoolId) {
        return all()
                .stream()
                .filter(teacher -> teacher.getSchool().getId() == schoolId)
                .collect(Collectors.toList());
    }
}
