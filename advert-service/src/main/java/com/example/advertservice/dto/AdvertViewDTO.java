package com.example.advertservice.dto;

import com.example.advertservice.model.Advert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertViewDTO {
    private Long id;
    private String title;
    private String information;
    private String description;
    private String location;
    private Date createdAt;
    private Date updatedAt;
    private String price;
    private int views;

    public static AdvertViewDTO of(Advert advert) {
        return new AdvertViewDTO(
                advert.getId(),
                advert.getTitle(),
                advert.getInformation(),
                advert.getDescription(),
                advert.getLocation(),
                advert.getCreatedAt(),
                advert.getUpdatedAt(),
                advert.getPrice(),
                advert.getAdvertViews());
    }
}
