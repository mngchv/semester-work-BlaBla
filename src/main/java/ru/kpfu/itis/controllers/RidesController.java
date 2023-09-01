package ru.kpfu.itis.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ru.kpfu.itis.dtos.*;
import ru.kpfu.itis.form.*;
import ru.kpfu.itis.models.*;
import ru.kpfu.itis.services.RideService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/rides")
public class RidesController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private RideService rideService;

    @GetMapping
    public ModelAndView getRidesPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("rides");
        List<Ride> rides = rideService.findAll();
        modelAndView.addObject("rides", rides);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView openRide(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ridePage");
        Ride ride = rideService.getById(id);
        if (ride.getId() == null) return new ModelAndView("redirect:/rides");
        modelAndView.addObject("ride", ride);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView createRide(String rideDestination, Authentication authentication) {
        if (rideDestination == null) return new ModelAndView("redirect:/profile");
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) authentication.getPrincipal();
        RideForm rideForm = RideForm.builder()
                .destination(rideDestination)
                .user(user)
                .build();
        Ride ride = rideService.createRide(rideForm);
        modelAndView.setViewName("redirect:/rides/" + ride.getId() + "/edit");
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView getEditRidePage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editRide");
        Ride ride = rideService.getById(id);
        modelAndView.addObject("ride", ride);
        return modelAndView;
    }

    // TODO: 21.05.2022
    @PostMapping("/destination")
    public void updateDestination(Long id, String destination) {
        rideService.updateRideDestination(id, destination);
    }
    // TODO: 21.05.2022

//    @PostMapping("/comment")
//    public void updateComment(Long id, String description) {
//        rideService.updateRideComment(id, description);
//    }



    @PostMapping("/addPrice")
    public void addPrice(PriceDto priceDto, HttpServletResponse response) throws IOException {
        System.out.println(priceDto);
        Ride ride = rideService.getById(priceDto.getRideID());
        PriceForm priceForm = PriceForm.builder()
                .title(priceDto.getTitle())
                .ride(ride)
                .build();
        System.out.println(priceForm);
        Price price = rideService.addPrice(priceForm);
        String json = objectMapper.writeValueAsString(price);
        response.setContentType("application/json");
        response.getWriter().println(json);
    }


    @PostMapping("/addComment")
    public void addProjectReview(CommentDto commentDto, HttpServletResponse response) throws IOException {
        Ride ride = rideService.getById(commentDto.getRideID());
        CommentForm commentForm = CommentForm.builder()
                .comment(commentDto.getComment())
                .ride(ride)
                .build();
        Comment comment = rideService.addComment(commentForm);
        String json = objectMapper.writeValueAsString(comment);
        response.setContentType("application/json");
        response.getWriter().println(json);
    }

    @PostMapping("/addContact")
    public void addContact(ContactDto contactDto, HttpServletResponse response) throws IOException {
        Ride ride = rideService.getById(contactDto.getRideId());
        ContactForm contactForm = ContactForm.builder()
                .title(contactDto.getTitle())
                .contact(contactDto.getContact())
                .ride(ride)
                .build();
        Contact contact = rideService.addContact(contactForm);
        String json = objectMapper.writeValueAsString(contact);
        response.setContentType("application/json");
        response.getWriter().println(json);
    }

    @PostMapping("/addRideType")
    public void addRideType(RideTypeDto rideTypeDto, HttpServletResponse response) throws IOException {
        Ride ride = rideService.getById(rideTypeDto.getRideID());
        RideTypeForm rideTypeForm = RideTypeForm.builder()
                .type(rideTypeDto.getType())
                .ride(ride)
                .build();
        RideType rideType = rideService.addRideType(rideTypeForm);
        String json = objectMapper.writeValueAsString(rideType);
        response.setContentType("application/json");
        response.getWriter().println(json);
    }

    @PostMapping("/addVehicle")
    public void addVehicle(VehicleDto vehicleDto, HttpServletResponse response) throws IOException {
        Ride ride = rideService.getById(vehicleDto.getRideId());
        VehicleForm vehicleForm = VehicleForm.builder()
                .model(vehicleDto.getModel())
                .seats(vehicleDto.getSeats())
                .ride(ride)
                .build();
        Vehicle vehicle = rideService.addVehicle(vehicleForm);
        String json = objectMapper.writeValueAsString(vehicle);
        response.setContentType("application/json");
        response.getWriter().println(json);
    }
}
