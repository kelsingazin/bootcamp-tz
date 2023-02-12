package kz.kelsingazin.bootcamp.services.impl;

import kz.kelsingazin.bootcamp.exceptions.ServiceException;
import kz.kelsingazin.bootcamp.models.entities.User;
import kz.kelsingazin.bootcamp.repositories.UserRepository;
import kz.kelsingazin.bootcamp.services.UserService;
import kz.kelsingazin.bootcamp.shared.utils.codes.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getActiveUserByPhoneNumber(String phoneNumber) {
        log.info("Get user by phone " + phoneNumber);
        return userRepository.findUserByPhoneNumberAndDeletedAtNull(phoneNumber)
                .orElseThrow(() -> ServiceException.builder()
                        .errorCode(ErrorCode.USER_NOT_FOUND)
                        .message("Пользователь не найден").build());
    }

    @Override
    public User getActiveUserByEmail(String email) {
        log.info("Get user by email " + email);
        return userRepository.findUserByEmailAndDeletedAtNull(email)
                .orElseThrow(() -> ServiceException.builder()
                        .errorCode(ErrorCode.USER_NOT_FOUND)
                        .message("Пользователь не найден").build());
    }

    @Override
    public List<User> getAllUsers() {
        log.info("Get all users");
        return userRepository.findAllByDeletedAtNull()
                .orElseThrow(() -> ServiceException.builder()
                        .errorCode(ErrorCode.USER_NOT_FOUND)
                        .message("Пользователь не найден").build());
    }

    @Override
    public User getActiveUserById(Long id) {
        log.info("Get user by id " + id);
        return userRepository.findUserByIdAndDeletedAtNull(id)
                .orElseThrow(() -> ServiceException.builder()
                        .errorCode(ErrorCode.USER_NOT_FOUND)
                        .message("Пользователь не найден").build());
    }
}
