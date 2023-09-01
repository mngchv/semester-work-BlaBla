package ru.kpfu.itis.form;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.models.User;

@Data
@Builder
public class RideForm {

    private String destination;
    private String departure;
    private String date;
    private User user;
}
