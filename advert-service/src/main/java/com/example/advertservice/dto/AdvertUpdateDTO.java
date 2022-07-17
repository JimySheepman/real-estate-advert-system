package com.example.advertservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertUpdateDTO {
    @NotBlank(message = "title is mandatory")
    @Size(min = 1, max = 160)
    private String title;

    @NotBlank(message = "information is mandatory")
    @Size(min = 1, max = 160)
    private String information;

    @NotBlank(message = "description is mandatory")
    @Size(min = 1, max = 160)
    private String description;

    @NotBlank(message = "location is mandatory")
    @Size(min = 3, max = 160)
    private String location;

    @NotBlank(message = "price is mandatory")
    @Size(min = 1, max = 16)
    private String price;
}
