package com.task.geolocation.model.dto;


public class GeolocationDto {

    private final String deviceId;
    private final float latitude;
    private final float longitude;

    public GeolocationDto(String deviceId, float lat, float lon){
        this.deviceId = deviceId;
        this.latitude = lat;
        this.longitude = lon;
    }

    public String getDeviceId(){
        return this.deviceId;
    }

    public float getLatitude(){
        return this.latitude;
    }

    public float getLongitude(){
        return this.longitude;
    }

}
