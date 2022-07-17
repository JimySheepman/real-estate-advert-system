package com.example.advertservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "adverts")
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String information;
    private String description;
    private String location;
    private Date createdAt;
    private Date updatedAt;
    private String price;

    @Builder.Default
    private int advertViews = 0;

    @Builder.Default
    private boolean status = false;

    public Advert(String title, String information, String description, String location, Date createdAt, Date updatedAt, String price) {
        this.title = title;
        this.information = information;
        this.description = description;
        this.location = location;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.price = price;
    }
}
