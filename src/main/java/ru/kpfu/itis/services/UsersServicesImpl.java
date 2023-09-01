package ru.kpfu.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.LoginForm;
import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.AuthRepository;
import ru.kpfu.itis.repositories.UsersRepository;

import javax.servlet.http.Cookie;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsersServicesImpl implements UsersService {

    @Autowired
    @Qualifier("UsersRepository")
    private UsersRepository usersRepository;

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registration(UserForm userForm) {

        User user = new User();
        user.setName(userForm.getName());
        user.setSurname(userForm.getSurname());
        user.setEmail(userForm.getEmail());

        String password = new BCryptPasswordEncoder().encode(userForm.getPassword());

        user.setPassword(password);

        return usersRepository.save(user);
    }

    @Override
    public Cookie login(LoginForm loginForm) {

        Optional<User> optionalUser = usersRepository.findUserByEmail(loginForm.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(loginForm.getPassword(), user.getPassword())) {
                System.out.println("Вход выполнен!");
                String cookieValue = UUID.randomUUID().toString();
                System.out.println(cookieValue);
                Cookie cookie = new Cookie("auth", cookieValue);
                cookie.setMaxAge(10 * 60 * 60);
                return cookie;
            } else {
                System.out.println("Вход не выполнен!");
            }
        }
        return null;
    }

    @Override
    public boolean emailDoesntExist(String email) {
        return usersRepository.existsByEmail(email);
    }

    @Override
    public void updateUserImage(Long userId, String imageSrc) {
        usersRepository.updateUserImage(userId, imageSrc);
    }
}
