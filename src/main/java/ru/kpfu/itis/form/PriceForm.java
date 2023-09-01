package ru.kpfu.itis.form;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.models.Ride;

@Data
@Builder
public class PriceForm {

    private String title;
    private Ride ride;

}
