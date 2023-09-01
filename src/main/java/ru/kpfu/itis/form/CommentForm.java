package ru.kpfu.itis.form;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.models.Ride;
import ru.kpfu.itis.models.User;

@Data
@Builder
public class CommentForm {

    private String comment;
    private Ride ride;
    private User user;


}
