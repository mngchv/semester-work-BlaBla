package ru.kpfu.itis.form;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.models.Ride;


@Data
@Builder
public class VehicleForm {

    private String model;
    private Ride ride;
    private Integer seats;

}
