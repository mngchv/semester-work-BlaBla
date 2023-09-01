package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.Contact;
import ru.kpfu.itis.models.Ride;

import java.util.List;

@Repository
public interface ContactsRepository extends JpaRepository<Contact, Long> {
    List<Contact> findAllByRide(Ride ride);
}
