package com.example.advertservice.mapper;


import com.example.advertservice.dto.AdvertCreateDTO;
import com.example.advertservice.dto.AdvertSendProducerDTO;
import com.example.advertservice.dto.AdvertUpdateDTO;
import com.example.advertservice.dto.AdvertViewDTO;
import com.example.advertservice.model.Advert;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AdvertModelMapper {

    public Advert toAdvert(AdvertCreateDTO advertCreateDTO, Date createdAt, Date updatedAt){
        return Advert
                .builder()
                .title(advertCreateDTO.getTitle())
                .information(advertCreateDTO.getInformation())
                .description(advertCreateDTO.getDescription())
                .location(advertCreateDTO.getLocation())
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .price(advertCreateDTO.getPrice())
                .build();
    }

    public AdvertViewDTO toAdvertViewDTO(Advert advert, AdvertUpdateDTO advertUpdateDTO,Date updatedAt){
        return AdvertViewDTO
                .builder()
                .title(advertUpdateDTO.getTitle())
                .information(advertUpdateDTO.getInformation())
                .description(advertUpdateDTO.getDescription())
                .location(advertUpdateDTO.getLocation())
                .createdAt(advert.getCreatedAt())
                .updatedAt(updatedAt)
                .price(advertUpdateDTO.getPrice())
                .views(advert.getAdvertViews())
                .build();
    }


    public AdvertViewDTO toAdvertViewDTO(Advert advert){
        return AdvertViewDTO
                .builder()
                .id(advert.getId())
                .title(advert.getTitle())
                .information(advert.getInformation())
                .description(advert.getDescription())
                .location(advert.getLocation())
                .createdAt(advert.getCreatedAt())
                .updatedAt(advert.getUpdatedAt())
                .price(advert.getPrice())
                .views(advert.getAdvertViews())
                .build();
    }

    public AdvertSendProducerDTO toAdvertSendProducerDTO(Advert advert) {
        return AdvertSendProducerDTO
                .builder()
                .id(advert.getId())
                .title(advert.getTitle())
                .information(advert.getInformation())
                .description(advert.getDescription())
                .location(advert.getLocation())
                .createdAt(advert.getCreatedAt())
                .updatedAt(advert.getUpdatedAt())
                .price(advert.getPrice())
                .views(advert.getAdvertViews())
                .status(advert.isStatus())
                .build();
    }
}

