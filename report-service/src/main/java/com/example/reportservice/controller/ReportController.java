package com.example.reportservice.controller;


import com.example.reportservice.dto.ReportUpdateDTO;
import com.example.reportservice.dto.ReportViewDTO;
import com.example.reportservice.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<ReportViewDTO> getReportById(@PathVariable Long id) {
        ReportViewDTO report = reportService.getReportById(id);
        return ResponseEntity.status(200).body(report);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<ReportViewDTO> save(@PathVariable("id") Long id, @RequestBody ReportUpdateDTO reportUpdateDTO) {
        ReportViewDTO report =reportService.save(reportUpdateDTO,id);
        return ResponseEntity.status(200).body(report);
    }
}
