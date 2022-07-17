package com.example.advertservice.service;

import com.example.advertservice.dto.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdvertService {
    void createAdvert(AdvertCreateDTO advertCreateDTO);
    AdvertViewDTO updateAdvert(Long id, AdvertUpdateDTO advertUpdateDTO);
    AdvertViewDTO changeAdvertStatus(Long id, boolean isApproved);

    List<AdvertViewDTO> findTop10ByOrderBySalaryDesc();

    List<AdvertViewForAdminDTO> getAllDisabledAdvert();
}
