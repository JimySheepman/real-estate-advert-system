package com.example.advertservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String information;
    private String description;
    private String location;
    private String price;

    @Builder.Default
    private boolean status = false;

    public Advert(String title, String information, String description, String location, String price) {
        this.title = title;
        this.information = information;
        this.description = description;
        this.location = location;
        this.price = price;
    }
}
