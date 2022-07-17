package com.example.advertservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertSendProducerDTO implements Serializable {

    private Long id;
    private String title;
    private String information;
    private String description;
    private String location;
    private Date createdAt;
    private Date updatedAt;
    private String price;
    private int views;
    private boolean status;

}
