package kz.kelsingazin.bootcamp.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kz.kelsingazin.bootcamp.controllers.base.BaseController;
import kz.kelsingazin.bootcamp.models.entities.User;
import kz.kelsingazin.bootcamp.models.mappers.UserMapper;
import kz.kelsingazin.bootcamp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController extends BaseController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping(value = "{id}",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation("Получение активного пользователя по id")
    public ResponseEntity<?> getActiveUserById(@ApiParam("ID элемента") @PathVariable Long id) {
        User activeUserById = userService.getActiveUserById(id);
        return buildResponse(userMapper.toDto(activeUserById), HttpStatus.OK);
    }

    @GetMapping(value = "/phone",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation("Получение активного пользователя по номеру телефона")
    public ResponseEntity<?> getActiveUserByPhoneNumber(@RequestParam String phoneNumber) {
        User activeUserByPhoneNumber = userService.getActiveUserByPhoneNumber(phoneNumber);
        return buildResponse(userMapper.toDto(activeUserByPhoneNumber), HttpStatus.OK);
    }

    @GetMapping(value = "/email",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation("Получение активного пользователя по почтовому адресу")
    public ResponseEntity<?> getActiveUserByEmail(@RequestParam String email) {
        User activeUserByEmail = userService.getActiveUserByEmail(email);
        return buildResponse(userMapper.toDto(activeUserByEmail), HttpStatus.OK);
    }

    @GetMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation("Получение всех активных пользователей")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return buildResponse(userMapper.toDtoList(users), HttpStatus.OK);
    }
}
