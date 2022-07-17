package com.example.advertservice.service;

import com.example.advertservice.dto.*;
import com.example.advertservice.exception.NotFoundException;
import com.example.advertservice.mapper.AdvertModelMapper;
import com.example.advertservice.model.Advert;
import com.example.advertservice.repository.AdvertRepository;
import lombok.RequiredArgsConstructor;
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

    private final AdvertModelMapper advertModelMapper;

    @Override
    public void createAdvert(AdvertCreateDTO advertCreateDTO) {
        Date createdAt = new Date();
        Date updatedAt = new Date();

        advertRepository.save( advertModelMapper.toAdvert(advertCreateDTO,createdAt,updatedAt));
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
    public AdvertViewDTO changeAdvertStatus(Long id, boolean isApproved) {
        final Advert advert = advertRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found Exception"));
        Date updatedAt = new Date();
        advert.setStatus(isApproved);
        advert.setUpdatedAt(updatedAt);
        return AdvertViewDTO.of(advert);
    }


    @Override
    public List<AdvertViewDTO> findTop10ByOrderByIdDesc() {
        return advertRepository.findTop10ByOrderByIdDesc()
                .stream()
                .map(AdvertViewDTO::of)
                .collect(Collectors.toList());
    }

    @Override
    public AdvertSendProducerDTO getAdvertForSent(Long id) {
        final Advert advert = advertRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found Exception"));
        return advertModelMapper.toAdvertSendProducerDTO(advert);
    }

    @Override
    public List<AdvertViewForAdminDTO> getAllDisabledAdvert() {
        return advertRepository.findAllByStatus(false)
                .stream()
                .map(AdvertViewForAdminDTO::of)
                .collect(Collectors.toList());
    }

    @Override
    public AdvertViewDTO getAdvert(Long id) {
        final Advert advert = advertRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found Exception"));
        advert.setAdvertViews(advert.getAdvertViews()+1);
        advertRepository.save(advert);
        return advertModelMapper.toAdvertViewDTO(advert);
    }

}
