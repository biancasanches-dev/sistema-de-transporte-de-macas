package com.example.hospital.service;

import com.example.hospital.model.dashboard.DashboardData;
import org.springframework.stereotype.Service;

@Service
public interface DashboardService {
        DashboardData getDashboardData();
}
