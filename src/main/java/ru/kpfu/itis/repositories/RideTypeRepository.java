package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.Ride;
import ru.kpfu.itis.models.RideType;


import java.util.List;

@Repository
public interface RideTypeRepository extends JpaRepository<RideType, Long> {

    List<RideType> findAllByRide(Ride ride);
}