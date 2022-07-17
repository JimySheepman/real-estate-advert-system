package com.example.reportservice.service;

import com.example.reportservice.dto.ReportCreateDTO;
import com.example.reportservice.dto.ReportUpdateDTO;
import com.example.reportservice.dto.ReportViewDTO;
import com.example.reportservice.exception.NotFoundException;
import com.example.reportservice.mapper.ReportModelMapper;
import com.example.reportservice.model.Report;
import com.example.reportservice.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{

    private ReportRepository reportRepository;

    private ReportModelMapper reportModelMapper;

    @Override
    public ReportViewDTO getReportById(Long id) {
        final Report report = reportRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found Exception"));
        return reportModelMapper.toReportViewDTO(report);
    }

    @Override
    public ReportViewDTO save(ReportUpdateDTO reportUpdateDTO, Long id) {
        Report report = reportRepository.save(reportModelMapper.toReport(reportUpdateDTO,id));
        return reportModelMapper.toReportViewDTO(report);
    }

}
