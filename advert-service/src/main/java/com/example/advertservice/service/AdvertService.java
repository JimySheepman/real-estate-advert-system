package com.example.advertservice.service;

import com.example.advertservice.dto.AdvertCreateDTO;
import com.example.advertservice.dto.AdvertUpdateDTO;
import com.example.advertservice.dto.AdvertUpdateStatusDTO;
import com.example.advertservice.dto.AdvertViewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdvertService {
    void createAdvert(AdvertCreateDTO advertCreateDTO);
    AdvertViewDTO updateAdvert(Long id, AdvertUpdateDTO advertUpdateDTO);
    AdvertViewDTO changeAdvertStatus(Long id, AdvertUpdateStatusDTO advertUpdateStatusDTO);
    List<AdvertViewDTO>  slice(Pageable pageable);
    List<AdvertViewDTO> findTop10ByOrderBySalaryDesc();
}
