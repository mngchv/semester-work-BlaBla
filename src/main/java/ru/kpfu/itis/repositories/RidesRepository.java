package ru.kpfu.itis.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.models.Ride;
import ru.kpfu.itis.models.User;

import java.util.List;

@Transactional
public interface RidesRepository extends JpaRepository<Ride, Long> {

    List<Ride> findAllByUser(User user);



    @Modifying
    @Query("update Ride r set r.destination = ?2 where r.id = ?1")
    void updateRideDestination(Long id, String destination);

//    @Modifying
//    @Query("update Ride r set r.description = ?2 where r.id = ?1")
//    void updateRideComment(Long id, String comment);
//    // TODO: 22.05.2022

}
