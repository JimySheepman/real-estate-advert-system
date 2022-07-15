package com.example.advertservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertCreateDTO {
    private String title;
    private String information;
    private String description;
    private String location;
    private String price;
}
