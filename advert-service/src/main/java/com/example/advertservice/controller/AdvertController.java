package com.example.advertservice.controller;

import com.example.advertservice.dto.AdvertCreateDTO;
import com.example.advertservice.dto.AdvertUpdateDTO;
import com.example.advertservice.dto.AdvertUpdateStatusDTO;
import com.example.advertservice.dto.AdvertViewDTO;
import com.example.advertservice.service.AdvertService;
import com.example.advertservice.utility.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/adverts")
@RequiredArgsConstructor
public class AdvertController {

    private final AdvertService advertService;

    @PostMapping
    public ResponseEntity<?> createAdvert(@RequestBody AdvertCreateDTO advertCreateDTO){
        advertService.createAdvert(advertCreateDTO);
        return ResponseEntity.ok(new GenericResponse("Advert Created."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdvertViewDTO> updateAdvert(@PathVariable("id")  Long id,  @RequestBody AdvertUpdateDTO advertUpdateDTO){
        final AdvertViewDTO advert = advertService.updateAdvert(id,advertUpdateDTO);
        return  ResponseEntity.ok(advert);
    }

    @PatchMapping("/manage/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<AdvertViewDTO> changeAdvertStatus(@PathVariable("id")  Long id,  @RequestBody AdvertUpdateStatusDTO advertUpdateStatusDTO){
        final AdvertViewDTO advert = advertService.changeAdvertStatus(id,advertUpdateStatusDTO);
        return  ResponseEntity.ok(advert);
    }

    @GetMapping("/manage")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<AdvertViewDTO>> slice(Pageable pageable){
        final List<AdvertViewDTO> users = advertService.slice(pageable);
        return ResponseEntity.ok(users);
    }

}
