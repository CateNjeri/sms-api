package com.great.school.services;

import com.great.school.models.data.School;
import com.great.school.models.response.Dashboard;

/**
 * Created by Kibet on 25-Nov-17.
 */
public interface DashboardService  {
    Dashboard getSchoolDashboard(long schoolId);

    Dashboard getStudentsDashboard(long studentId);

    Dashboard getAdminDashboard();
}
