package com.example.advertservice.repository;

import com.example.advertservice.model.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertRepository extends JpaRepository<Advert,Long> {
    // TODO: how to add where conditon
    // List<Advert> findAllByStatusAndFindTop10ByOrderByIdAsc(boolean status);
    List<Advert> findTop10ByOrderByIdDesc();
    List<Advert> findAllByStatus(boolean status);
}
