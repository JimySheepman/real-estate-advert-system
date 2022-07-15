package com.example.advertservice.service;

import com.example.advertservice.dto.AdvertCreateDTO;
import com.example.advertservice.dto.AdvertUpdateDTO;
import com.example.advertservice.dto.AdvertUpdateStatusDTO;
import com.example.advertservice.dto.AdvertViewDTO;
import com.example.advertservice.exception.NotFoundException;
import com.example.advertservice.model.Advert;
import com.example.advertservice.repository.AdvertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository advertRepository;

    @Override
    public void createAdvert(AdvertCreateDTO advertCreateDTO) {
        advertRepository.save(
                new Advert(
                        advertCreateDTO.getTitle(),
                        advertCreateDTO.getInformation(),
                        advertCreateDTO.getDescription(),
                        advertCreateDTO.getLocation(),
                        advertCreateDTO.getPrice()));
    }

    @Override
    public AdvertViewDTO updateAdvert(Long id, AdvertUpdateDTO advertUpdateDTO) {
        final Advert advert = advertRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found Exception"));
        advert.setTitle(advertUpdateDTO.getTitle());
        advert.setInformation(advertUpdateDTO.getInformation());
        advert.setDescription(advertUpdateDTO.getDescription());
        advert.setLocation(advertUpdateDTO.getLocation());
        advert.setPrice(advertUpdateDTO.getPrice());
        advert.setStatus(false);
        return AdvertViewDTO.of(advert);
    }

    @Override
    public AdvertViewDTO changeAdvertStatus(Long id, AdvertUpdateStatusDTO advertUpdateStatusDTO) {
        final Advert advert = advertRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found Exception"));
        advert.setStatus(advertUpdateStatusDTO.isStatus());
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
}