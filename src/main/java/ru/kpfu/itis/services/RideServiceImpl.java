package ru.kpfu.itis.services;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.*;
import ru.kpfu.itis.models.*;
import ru.kpfu.itis.repositories.*;

import java.util.List;
import java.util.Optional;

@Service
public class RideServiceImpl implements RideService {

    @Autowired
    private RidesRepository ridesRepository;
    @Autowired
    private RideTypeRepository rideTypeRepository;
    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ContactsRepository contactsRepository;

    @Value("$mingachevr@mail.ru")
    private String senderEmail;

    @Value("${4G82dPSg3dfEM96hZ3GU}")
    private String senderPassword;

    @Override
    public Ride createRide(RideForm rideForm) {
        Ride ride = Ride.builder()
                .destination(rideForm.getDestination())
                .departure(rideForm.getDeparture())
                .date(rideForm.getDate())
                .user(rideForm.getUser())
                .build();
        Ride ride1 = ridesRepository.save(ride);
        sendNotificationEmail(ride1);
        return ride1;
    }

    @Override
    public Ride getById(Long rideId) {
        Optional<Ride> optional = ridesRepository.findById(rideId);
        if (optional.isPresent()) {
            Ride ride = optional.get();
            ride.setRideTypes(findAllRideTypesByRide(ride));
            ride.setPrices(findAllPricesByRide(ride));
            ride.setVehicles(findAllVehiclesByRide(ride));
            ride.setComments(findAllCommentsByRide(ride));
            return ride;
        }
        return null;
    }

    @Override
    public List<Ride> findAll() {
        List<Ride> rides = ridesRepository.findAll();
        for (Ride ride : rides) {
            ride.setRideTypes(findAllRideTypesByRide(ride));
            ride.setPrices(findAllPricesByRide(ride));
            ride.setVehicles(findAllVehiclesByRide(ride));
            ride.setComments(findAllCommentsByRide(ride));
        }
        return rides;
    }

    @Override
    public List<Ride> findAllByUser(User user) {
        List<Ride> rides = ridesRepository.findAllByUser(user);
        for (Ride ride : rides) {
            ride.setRideTypes(findAllRideTypesByRide(ride));
            ride.setPrices(findAllPricesByRide(ride));
            ride.setVehicles(findAllVehiclesByRide(ride));
            ride.setComments(findAllCommentsByRide(ride));
        }
        return rides;
    }

    @Override
    public void updateRideDestination(Long id, String destination) {
        ridesRepository.updateRideDestination(id, destination);
    }

//    @Override
//    public void updateRideComment(Long id, String comment) {
//        ridesRepository.updateRideComment(id, comment);
//}

    @Override
    public Vehicle addVehicle (VehicleForm vehicleForm) {
        Vehicle vehicle = Vehicle.builder()
                .model(vehicleForm.getModel())
                .seats(vehicleForm.getSeats())
                .ride(vehicleForm.getRide())
                .build();
        return vehicleRepository.save(vehicle);
    }


    @Override
    public Price addPrice(PriceForm priceForm) {
        Price price = Price.builder()
                .title(priceForm.getTitle())
                .ride(priceForm.getRide())
                .build();
        return priceRepository.save(price);
    }

    @Override
    public Comment addComment(CommentForm commentForm) {
        Comment comment = Comment.builder()
                .comment(commentForm.getComment())
                .ride(commentForm.getRide())
                .build();
        return commentRepository.save(comment);
    }

    @Override
    public RideType addRideType(RideTypeForm rideTypeForm) {
        RideType rideType = RideType.builder()
                .type(rideTypeForm.getType())
                .ride(rideTypeForm.getRide())
                .build();
        return rideTypeRepository.save(rideType);
    }

    @Override
    public Contact addContact(ContactForm contactForm) {
        Contact contact = Contact.builder()
                .title(contactForm.getTitle())
                .contact(contactForm.getContact())
                .ride(contactForm.getRide())
                .build();
        return contactsRepository.save(contact);
    }


    @Override
    public List<Comment> findAllCommentsByRide(Ride ride) {
        List<Comment> comments = commentRepository.findAllByRide(ride);
        for (Comment comment : comments) {
            comment.setRide(null);
        }
        return comments;
    }
    @Override
    public List<RideType> findAllRideTypesByRide(Ride ride) {
        List<RideType> rideTypes = rideTypeRepository.findAllByRide(ride);
        for (RideType rideType : rideTypes) {
            rideType.setRide(null);
        }
        return rideTypes;
    }

    @Override
    public List<Vehicle> findAllVehiclesByRide(Ride ride) {
        List<Vehicle> vehicles = vehicleRepository.findAllByRide(ride);
        for (Vehicle vehicle : vehicles) {
            vehicle.setRide(null);
        }
        return vehicles;
    }

    @Override
    public List<Price> findAllPricesByRide(Ride ride) {
        List<Price> prices = priceRepository.findAllByRide(ride);
        for (Price price : prices) {
            price.setRide(null);
        }
        return prices;
    }

    @Override
    public void sendNotificationEmail(Ride ride) {
        try {
            Email emailMessage = new SimpleEmail();
            emailMessage.setSmtpPort(25);
            emailMessage.setAuthenticator(new DefaultAuthenticator(senderEmail, senderPassword));
            emailMessage.setHostName("smtp.mail.ru");
            emailMessage.setSSLOnConnect(true);
            emailMessage.setFrom(senderEmail);
            emailMessage.setSubject("Создано новое объявление!");
            User user = ride.getUser();
            emailMessage.setMsg("Вы - " + user.getName() + " " + user.getSurname() +
                    ",создали новое объявление" + ride.getDestination() + "\n" +
                    " можете посмотреть или изменить его на странице профиля...");
            emailMessage.addTo(user.getEmail());
            emailMessage.send();
            System.out.println("Подтверждение успешно отправлено");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка при отправке подтверждения");
        }
    }
    }
