package com.example.reportservice.dto;

import com.example.reportservice.model.Report;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportViewDTO {
    @Id
    private String id;
    private String username;
    private String createAt;
    private int views;


    public static ReportViewDTO of (Report report){
        return new ReportViewDTO(
                report.getId(),
                report.getUsername(),
                report.getCreateAt(),
                report.getViews()
        );
    }
}
