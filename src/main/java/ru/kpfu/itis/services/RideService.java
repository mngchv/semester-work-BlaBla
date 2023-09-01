package ru.kpfu.itis.services;

import ru.kpfu.itis.form.*;
import ru.kpfu.itis.models.*;

import java.util.List;

public interface RideService {

    Ride createRide(RideForm rideForm);

    Ride getById(Long rideId);

    List<Ride> findAll();

    List<Ride> findAllByUser(User user);

    void updateRideDestination(Long id, String destination);


    Contact addContact(ContactForm contactForm);

    Vehicle addVehicle(VehicleForm vehicleForm);

    Price addPrice(PriceForm priceForm);

    Comment addComment(CommentForm commentForm);

    RideType addRideType(RideTypeForm rideTypeForm);

    List<RideType> findAllRideTypesByRide(Ride ride);

    List<Vehicle> findAllVehiclesByRide(Ride ride);

    List<Comment> findAllCommentsByRide(Ride ride);

    List<Price> findAllPricesByRide(Ride ride);



    void sendNotificationEmail(Ride ride);

}

