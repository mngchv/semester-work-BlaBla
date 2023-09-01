package ru.kpfu.itis.form;

import lombok.Data;
import ru.kpfu.itis.models.Vehicle;

@Data
public class UserForm {
    private String email;
    private String password;
    private String surname;
    private String name;
    private String phone;
    private Vehicle vehicle;
}
