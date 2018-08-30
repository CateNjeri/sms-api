package com.great.school.services.impl;

import com.great.school.models.data.Parent;
import com.great.school.models.data.Student;
import com.great.school.repositories.StudentRepository;
import com.great.school.services.ParentService;
import com.great.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ParentService parentService;

    @Override
    public Student add(Student student) {
        Parent parent = parentService.add(student.getParent());
        student.setParent(parent);
        return studentRepository.save(student);
    }

    @Override
    public void delete(long id) {
        studentRepository.delete(id);
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getById(long id) {
        return studentRepository.getOne(id);
    }

    @Override
    public List<Student> all() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findBySchoolId(long schoolId) {
        return all()
                .stream()
                .filter(student -> student.getSchool().getId() == schoolId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> findByParentId(long parentId) {
        return studentRepository.findByParentId(parentId);
    }

    @Override
    public List<Student> findByUserAccountId(long userAccountId) {
        List<Student> students = new ArrayList<>();
        parentService.findByUserAccountId(userAccountId)
                .forEach(parent -> students.addAll(parent.getStudents()));

        return students;
      /*  return all()
                .stream().filter(student -> student.getParent() != null && student.getParent().getUserAccount() != null
                        && student.getParent().getUserAccount().getId() == userAccountId)
                .collect(Collectors.toList());
*/
    }
}
