package ru.kpfu.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ride")
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(name = "destination")
    private String destination;

    @Column(name = "departure")
    private String departure;

    @Column(name = "date")
    private String date;

    @OneToMany
    private List<Price> prices;

    @OneToMany
    private List<RideType> rideTypes;

    @OneToMany
    private List<Comment> comments;

    @OneToMany
    private List<Vehicle> vehicles;

    @OneToMany
    private List<Contact> contacts;

}
