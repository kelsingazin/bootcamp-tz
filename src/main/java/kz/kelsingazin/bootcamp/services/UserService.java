package kz.kelsingazin.bootcamp.services;

import kz.kelsingazin.bootcamp.models.entities.User;

import java.util.List;

public interface UserService {

    User getActiveUserByPhoneNumber(String phoneNumber);

    User getActiveUserByEmail(String email);
        
    List<User> getAllUsers();

    User getActiveUserById(Long id);
}
