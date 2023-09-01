package ru.kpfu.itis.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.kpfu.itis.dtos.RegistrationDto;
import ru.kpfu.itis.services.UsersService;

import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UsersService usersService;

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationDto.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        RegistrationDto registrationDto = (RegistrationDto) obj;
        ValidationUtils.rejectIfEmpty(errors, "name", "name", "Не указано Имя");
        ValidationUtils.rejectIfEmpty(errors, "surname", "surname", "Не указано Фамилия");
        ValidationUtils.rejectIfEmpty(errors, "email", "email", "Не указан Логин");
        ValidationUtils.rejectIfEmpty(errors, "password", "password", "Не указан Пароль");

        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE);
        if (!(pattern.matcher(registrationDto.getEmail()).matches())) {
            errors.reject("email", "Неправильный email");
        }

        if (!usersService.emailDoesntExist(registrationDto.getEmail())) {
            errors.reject("email", "Пользователь с таким логином существует");
        }

        if (!registrationDto.getPassword().equals(registrationDto.getConfirmPassword())) {
            errors.reject("confirmPassword", "Пароли не совпадают");
        }
    }
}
