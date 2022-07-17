package com.example.advertservice.service;

import com.example.advertservice.dto.*;

import java.util.List;

public interface AdvertService {
    void createAdvert(AdvertCreateDTO advertCreateDTO);
    AdvertViewDTO updateAdvert(Long id, AdvertUpdateDTO advertUpdateDTO);
    AdvertViewDTO changeAdvertStatus(Long id, boolean isApproved);
    List<AdvertViewForAdminDTO> getAllDisabledAdvert();
    AdvertViewDTO getAdvert(Long id);

    List<AdvertViewDTO> findTop10ByOrderByIdDesc();

    AdvertSendProducerDTO getAdvertForSent(Long id);
}
