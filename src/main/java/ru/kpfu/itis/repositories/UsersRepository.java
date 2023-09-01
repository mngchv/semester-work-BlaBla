package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.models.User;

import java.util.Optional;

@Repository("UsersRepository")
@Transactional
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);

    boolean existsByEmail(String email);


    @Modifying
    @Query("update User u set u.imageSrc = ?2 where u.id = ?1")
    void updateUserImage(Long id, String imageSrc);
}
