package com.great.school.controllers;

import com.great.school.models.data.FeeTransaction;
import com.great.school.models.response.Dashboard;
import com.great.school.services.DashboardService;
import com.great.school.services.FeeTransactionService;
import com.great.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @GetMapping()
    public ResponseEntity<Dashboard> adminDashboard() {
        return ResponseEntity.ok(dashboardService.getAdminDashboard());
    }

    @GetMapping("schools/{id}")
    public ResponseEntity<Dashboard> schoolsDashboard(@PathVariable long id) {
        return ResponseEntity.ok(dashboardService.getSchoolDashboard(id));
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Dashboard> studentsDashboard(@PathVariable long id) {
        return ResponseEntity.ok(dashboardService.getStudentsDashboard(id));
    }
}
