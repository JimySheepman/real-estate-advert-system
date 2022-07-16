package com.example.reportservice.service;

import com.example.reportservice.model.Report;

public interface ReportService {
    Report getReportById(Long id);

    Report save(Report report);
}
