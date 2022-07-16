package com.example.reportservice.service;

import com.example.reportservice.dto.ReportViewDTO;
import com.example.reportservice.exception.NotFoundException;
import com.example.reportservice.model.Report;
import com.example.reportservice.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{

    private ReportRepository reportRepository;

    @Override
    public Report getReportById(Long id) {
        final Report report = reportRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found Exception"));
        report.setViews(report.getViews()+1);
        return report;
    }

    @Override
    public Report save(Report report) {
        return reportRepository.save(report);
    }
}
