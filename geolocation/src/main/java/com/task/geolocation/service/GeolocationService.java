package com.task.geolocation.service;

import com.task.geolocation.model.entity.Geolocation;
import com.task.geolocation.model.dto.GeolocationDto;
import com.task.geolocation.repository.GeolocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class GeolocationService {

    private final GeolocationRepository geolocationRepository;

    private static final Logger logger = LoggerFactory.getLogger(GeolocationService.class);

    public GeolocationService(GeolocationRepository geolocationRepository) {
        this.geolocationRepository = geolocationRepository;
    }

    @Transactional
    public Geolocation saveGeolocation(GeolocationDto locationDTO) {
        logger.info("Save new geolocation in repository - device: " + locationDTO.getDeviceId() + "latitude: " + locationDTO.getLatitude() + "longitude: " + locationDTO.getLongitude() +
                " Start Time: " + Instant.now());
        return geolocationRepository.save(new Geolocation(locationDTO.getDeviceId(), locationDTO.getLatitude(), locationDTO.getLongitude()));
    }
}
