package com.example.advertservice.controller;

import com.example.advertservice.dto.*;
import com.example.advertservice.producer.AdvertProducer;
import com.example.advertservice.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/adverts")
@RequiredArgsConstructor
public class AdvertController {

    private final AdvertService advertService;

    private final AdvertProducer advertProducer;

    @GetMapping("/{id}")
    public ResponseEntity<AdvertViewDTO> getAdvert(@PathVariable("id") Long id){
        final AdvertViewDTO advert = advertService.getAdvert(id);
        return  ResponseEntity.ok(advert);
    }

    @GetMapping
    public ResponseEntity<List<AdvertViewDTO>> findTop10ByOrderByIdDesc(){
        final List<AdvertViewDTO> adverts = advertService.findTop10ByOrderByIdDesc();
        return ResponseEntity.ok(adverts);
    }

    @PostMapping
    public ResponseEntity<?> createAdvert(@RequestBody AdvertCreateDTO advertCreateDTO){
        advertService.createAdvert(advertCreateDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdvertViewDTO> updateAdvert(@PathVariable("id")  Long id,  @RequestBody AdvertUpdateDTO advertUpdateDTO){
        final AdvertViewDTO advert = advertService.updateAdvert(id,advertUpdateDTO);
        return  ResponseEntity.ok(advert);
    }

    @GetMapping("/manage/rejects")
    // @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<List<AdvertViewForAdminDTO>> getAllDisabledAdvert(){
        final List<AdvertViewForAdminDTO> disabledAdverts = advertService.getAllDisabledAdvert();
        return ResponseEntity.ok(disabledAdverts);
    }

    @PatchMapping("/manage/{id}/approve")
    // @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<AdvertViewDTO> changeAdvertStatusApprove(@PathVariable("id")  Long id){
        final AdvertViewDTO advert = advertService.changeAdvertStatus(id,true);
        final AdvertSendProducerDTO advertSendProducerDTO = advertService.getAdvertForSent(advert.getId());
        advertProducer.sendToQueue(advertSendProducerDTO);
        return  ResponseEntity.ok(advert);
    }

    @PatchMapping("/manage/{id}/disapprove")
    // @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<AdvertViewDTO> changeAdvertStatusDisapprove(@PathVariable("id")  Long id){
        final AdvertViewDTO advert = advertService.changeAdvertStatus(id,false);
        return  ResponseEntity.ok(advert);
    }

}
