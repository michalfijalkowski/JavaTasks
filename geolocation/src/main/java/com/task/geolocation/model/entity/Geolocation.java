package com.task.geolocation.model.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "geolocation")
public class Geolocation implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private String id;

    @Column(name = "device")
    @NotNull
    private final String deviceId;

    @Column(name = "latitude")
    @NotNull
    private final float latitude;

    @Column(name = "longitude")
    @NotNull
    private final float longitude;

    public Geolocation(String device, float lat, float lon){
        this.deviceId = device;
        this.latitude = lat;
        this.longitude = lon;
    }

    public String getId() {
        return this.id;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public float getLatitude(){
        return this.latitude;
    }

    public float getLongitude(){
        return this.longitude;
    }

}
