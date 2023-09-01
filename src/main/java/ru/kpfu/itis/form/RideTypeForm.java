package ru.kpfu.itis.form;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.models.Ride;

@Data
@Builder
public class RideTypeForm {

    private String type;
    private Ride ride;

}
