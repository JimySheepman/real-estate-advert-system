package com.example.advertservice.service;

import com.example.advertservice.dto.AdvertCreateDTO;
import com.example.advertservice.dto.AdvertUpdateDTO;
import com.example.advertservice.dto.AdvertUpdateStatusDTO;
import com.example.advertservice.dto.AdvertViewDTO;
import com.example.advertservice.exception.NotFoundException;
import com.example.advertservice.model.Advert;
import com.example.advertservice.repository.AdvertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository advertRepository;

    @Override
    public void createAdvert(AdvertCreateDTO advertCreateDTO) {
        Date createdAt = new Date();
        Date updatedAt = new Date();
        System.out.println(createdAt+"\n"+updatedAt);

        advertRepository.save(
                new Advert(
                        advertCreateDTO.getTitle(),
                        advertCreateDTO.getInformation(),
                        advertCreateDTO.getDescription(),
                        advertCreateDTO.getLocation(),
                        createdAt,
                        updatedAt,
                        advertCreateDTO.getPrice()));
    }

    @Override
    public AdvertViewDTO updateAdvert(Long id, AdvertUpdateDTO advertUpdateDTO) {
        final Advert advert = advertRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found Exception"));
        Date updatedAt = new Date();
        advert.setTitle(advertUpdateDTO.getTitle());
        advert.setInformation(advertUpdateDTO.getInformation());
        advert.setDescription(advertUpdateDTO.getDescription());
        advert.setLocation(advertUpdateDTO.getLocation());
        advert.setPrice(advertUpdateDTO.getPrice());
        advert.setUpdatedAt(updatedAt);
        advert.setStatus(false);
        return AdvertViewDTO.of(advert);
    }

    @Override
    public AdvertViewDTO changeAdvertStatus(Long id, AdvertUpdateStatusDTO advertUpdateStatusDTO) {
        final Advert advert = advertRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found Exception"));
        Date updatedAt = new Date();
        advert.setStatus(advertUpdateStatusDTO.isStatus());
        advert.setUpdatedAt(updatedAt);
        return AdvertViewDTO.of(advert);
    }

    @Override
    public List<AdvertViewDTO> slice(Pageable pageable) {

        return advertRepository
                .findAll(pageable)
                .stream()
                .map(AdvertViewDTO::of)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdvertViewDTO> findTop10ByOrderBySalaryDesc() {
        return advertRepository.findTop10ByOrderByIdDesc()
                .stream()
                .map(AdvertViewDTO::of)
                .collect(Collectors.toList());
    }

}
