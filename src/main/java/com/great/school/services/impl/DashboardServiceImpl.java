package com.great.school.services.impl;

import com.great.school.models.response.Dashboard;
import com.great.school.models.response.DashboardStat;
import com.great.school.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Kibet on 01-Dec-17.
 */
@Service("dashboardService")
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    FeeTransactionService feeTransactionService;

    @Autowired
    ParentService parentService;

    @Override
    public Dashboard getSchoolDashboard(long schoolId) {
        Dashboard dashboard = new Dashboard();
        dashboard.studentsCount = studentService.findBySchoolId(schoolId).size();
        dashboard.teachersCount = teacherService.findBySchoolId(schoolId).size();
        dashboard.parentsCount = parentService.findInSchool(schoolId).size();


        return dashboard;
    }

    @Override
    public Dashboard getStudentsDashboard(long studentId) {
        Dashboard dashboard = new Dashboard();

        return dashboard;
    }

    @Override
    public Dashboard getAdminDashboard() {
        return null;
    }
}
