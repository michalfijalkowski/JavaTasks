package com.task.geolocation.service;

import com.task.geolocation.model.dto.GeolocationDto;
import com.task.geolocation.model.entity.Geolocation;
import com.task.geolocation.repository.GeolocationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class GeolocationServiceTest {

    @Autowired
    private GeolocationRepository geolocationRepository;

    @Autowired
    private GeolocationService geolocationService;

    @Transactional
    @Test
    public void saveFirstDeviceGeolocation(){
        final GeolocationDto geolocationDto = new GeolocationDto("id1", 123f, 456f);

        final Geolocation geolocation = geolocationService.saveGeolocation(geolocationDto);

        Assertions.assertTrue(geolocationRepository.findById(geolocation.getId()).isPresent(), "Saving first device geolocation failed.");
    }

    @Transactional
    @Test
    public void saveTwoGeolocationFromOneDevice(){
        final GeolocationDto geolocationDto = new GeolocationDto("id1", 123f, 456f);
        final GeolocationDto geolocationDto2 = new GeolocationDto("id1", 135f, 246);


        final Geolocation geolocation = geolocationService.saveGeolocation(geolocationDto);
        final Geolocation geolocation2 = geolocationService.saveGeolocation(geolocationDto2);

        Assertions.assertTrue(geolocationRepository.findById(geolocation.getId()).isPresent() && geolocationRepository.findById(geolocation2.getId()).isPresent(), "Saving two geolocation from same device failed.");
    }

}