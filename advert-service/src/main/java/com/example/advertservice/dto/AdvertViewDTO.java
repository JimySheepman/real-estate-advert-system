package com.example.advertservice.dto;

import com.example.advertservice.model.Advert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String price;

    public static AdvertViewDTO of(Advert advert){
        return new AdvertViewDTO(
                advert.getId(),
                advert.getTitle(),
                advert.getInformation(),
                advert.getDescription(),
                advert.getLocation(),
                advert.getPrice());
    }
}
