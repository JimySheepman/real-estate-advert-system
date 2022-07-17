package com.example.reportservice.service;

import com.example.reportservice.dto.ReportCreateDTO;
import com.example.reportservice.dto.ReportUpdateDTO;
import com.example.reportservice.dto.ReportViewDTO;
import com.example.reportservice.model.Report;
import org.springframework.http.ResponseEntity;

public interface ReportService {

    ReportViewDTO getReportById(Long id);

    ReportViewDTO save(ReportUpdateDTO reportUpdateDTO, Long id);
}
