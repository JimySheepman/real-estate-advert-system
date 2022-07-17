package com.example.advertservice.controller;

import com.example.advertservice.dto.*;
import com.example.advertservice.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/adverts")
@RequiredArgsConstructor
public class AdvertController {

    // findById - GET views ekle
    private final AdvertService advertService;

    @GetMapping
    public ResponseEntity<List<AdvertViewDTO>> findTop10ByOrderBySalaryDesc(){
        final List<AdvertViewDTO> users = advertService.findTop10ByOrderBySalaryDesc();
        return ResponseEntity.ok(users);
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

    @GetMapping("/manage")
    public ResponseEntity<List<AdvertViewForAdminDTO>> getAllDisabledAdvert(){
        final List<AdvertViewForAdminDTO> disabledAdverts = advertService.getAllDisabledAdvert();
        return ResponseEntity.ok(disabledAdverts);
    }

    @PatchMapping("/manage/{id}/approve")
    public ResponseEntity<AdvertViewDTO> changeAdvertStatusApprove(@PathVariable("id")  Long id){
        final AdvertViewDTO advert = advertService.changeAdvertStatus(id,true);
        return  ResponseEntity.ok(advert);
    }

    @PatchMapping("/manage/{id}/disapprove")
    public ResponseEntity<AdvertViewDTO> changeAdvertStatusDisapprove(@PathVariable("id")  Long id){
        final AdvertViewDTO advert = advertService.changeAdvertStatus(id,false);
        return  ResponseEntity.ok(advert);
    }

}
