package com.great.school.models.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kibet on 01-Dec-17.
 */
public class Dashboard {
    public List<DashboardStat> dashboardStats;
    public int studentsCount;
    public int teachersCount;
    public int parentsCount;

    public Dashboard() {
        this.dashboardStats = new ArrayList<>();
    }

    public void addDashboardStat(DashboardStat dashboardStat) {
        if (dashboardStats == null) {
            dashboardStats = new ArrayList<>();
        }
        dashboardStats.add(dashboardStat);
    }
}
