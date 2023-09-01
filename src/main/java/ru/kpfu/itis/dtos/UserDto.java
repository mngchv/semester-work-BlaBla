package ru.kpfu.itis.dtos;

import lombok.Data;
@Data
public class UserDto {

        private String name;
        private String surname;
        private String email;
        private String password;
        private String retype_password;
    }

