package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.dtos.RegistrationDto;
import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.services.UsersService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UsersService usersService;



    @GetMapping
    public ModelAndView registrationPage() {
        return new ModelAndView("registration");
    }

    @PostMapping
    public ModelAndView registrationUser(RegistrationDto registrationDto) {
        ModelAndView modelAndView = new ModelAndView();

        UserForm userForm = new UserForm();
        userForm.setEmail(registrationDto.getEmail());
        userForm.setPassword(registrationDto.getPassword());
        userForm.setName(registrationDto.getName());
        userForm.setSurname(registrationDto.getSurname());

        usersService.registration(userForm);

        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }
}
