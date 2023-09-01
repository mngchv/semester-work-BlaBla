package ru.kpfu.itis.dtos;

import lombok.Data;

@Data
public class VehicleDto {

    private Long rideId;
    private String model;
    private Integer seats;
}
