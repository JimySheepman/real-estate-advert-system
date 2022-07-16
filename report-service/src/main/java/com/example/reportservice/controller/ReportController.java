package com.example.reportservice.controller;


import com.example.reportservice.dto.ReportViewDTO;
import com.example.reportservice.model.Report;
import com.example.reportservice.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/{id}")
    public Report getReportById(@PathVariable Long id){
        return reportService.getReportById(id);
    }

    @PostMapping
    public Report save(@RequestBody Report report){
        return reportService.save(report);
    }
}
