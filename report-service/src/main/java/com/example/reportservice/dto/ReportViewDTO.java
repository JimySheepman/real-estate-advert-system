package com.example.reportservice.dto;

import com.example.reportservice.model.Report;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportViewDTO {

    private Long id;
    private String username;
    private Date createdAt;
    private int views;


    public static ReportViewDTO of (Report report){
        return new ReportViewDTO(
                report.getId(),
                report.getUsername(),
                report.getCreatedAt(),
                report.getViews()
        );
    }
}
