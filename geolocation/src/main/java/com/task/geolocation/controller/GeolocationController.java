package com.task.geolocation.controller;

import com.task.geolocation.model.entity.Geolocation;
import com.task.geolocation.model.dto.GeolocationDto;
import com.task.geolocation.service.GeolocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
class GeolocationController {

    private final GeolocationService geolocationService;
    private static final Logger logger = LoggerFactory.getLogger(GeolocationController.class);

    public GeolocationController(GeolocationService geolocationService) {
        this.geolocationService = geolocationService;
    }

    @PostMapping("/geolocation")
    Geolocation newGeolocation(@RequestBody GeolocationDto location) {
        logger.info("Request save new geolocation - device: " + location.getDeviceId() +
                " Start Time: " + Instant.now());
        return geolocationService.saveGeolocation(location);
    }
}
