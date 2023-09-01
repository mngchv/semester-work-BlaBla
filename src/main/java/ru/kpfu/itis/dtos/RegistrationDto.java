package ru.kpfu.itis.dtos;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String confirmPassword;
    private String phone;
    private Long vehicleID;
}
