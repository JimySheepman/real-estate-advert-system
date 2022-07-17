package com.example.reportservice.mapper;

import com.example.reportservice.dto.ConsumerReceiveMessageDTO;
import com.example.reportservice.dto.ReportUpdateDTO;
import com.example.reportservice.dto.ReportViewDTO;
import com.example.reportservice.model.Report;
import org.springframework.stereotype.Service;

@Service
public class ReportModelMapper {
    public ReportViewDTO toReportViewDTO(Report report) {
        return ReportViewDTO
                .builder()
                .id(report.getId())
                .username(report.getUsername())
                .createdAt(report.getCreatedAt())
                .views(report.getViews())
                .build();
    }

    public Report toReport(ReportUpdateDTO reportUpdateDTO, Long id) {
        return Report
                .builder()
                .id(id)
                .username(reportUpdateDTO.getUsername())
                .createdAt(reportUpdateDTO.getCreatedAt())
                .views(reportUpdateDTO.getViews())
                .build();
    }

    public Report toReport(ConsumerReceiveMessageDTO consumerReceiveMessageDTO) {
        return Report
                .builder()
                .id(consumerReceiveMessageDTO.getId())
                .createdAt(consumerReceiveMessageDTO.getCreatedAt())
                .views(consumerReceiveMessageDTO.getViews())
                .build();
    }
}
