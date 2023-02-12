package kz.kelsingazin.bootcamp.repositories;

import kz.kelsingazin.bootcamp.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String login);

    Optional<User> findUserByPhoneNumberAndDeletedAtNull(String phoneNumber);

    Optional<User> findUserByIdAndDeletedAtNull(Long id);

    Optional<User> findUserByEmailAndDeletedAtNull(String email);

    Optional<List<User>> findAllByDeletedAtNull();
}
