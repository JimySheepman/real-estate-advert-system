package com.example.reportservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String username;
    private String createdAt;
    private int views;

    public Report(String username, String createAt, int views) {
        this.username = username;
        this.createdAt = createAt;
        this.views = views;
    }
}
