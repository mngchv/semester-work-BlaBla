package ru.kpfu.itis.services;

import ru.kpfu.itis.form.LoginForm;
import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.models.User;

import javax.servlet.http.Cookie;

public interface UsersService {
    User registration(UserForm userForm);
    Cookie login(LoginForm loginForm);
    boolean emailDoesntExist(String email);
    void updateUserImage(Long userId, String imageSrc);
}

