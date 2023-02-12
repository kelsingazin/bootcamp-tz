package kz.kelsingazin.bootcamp.controllers.auth;

import kz.kelsingazin.bootcamp.controllers.base.BaseController;
import kz.kelsingazin.bootcamp.models.entities.User;
import kz.kelsingazin.bootcamp.models.mappers.UserMapper;
import kz.kelsingazin.bootcamp.models.requests.AuthenticationRequest;
import kz.kelsingazin.bootcamp.models.requests.RegisterRequest;
import kz.kelsingazin.bootcamp.models.responses.AuthenticationResponse;
import kz.kelsingazin.bootcamp.services.impl.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController extends BaseController {

    private final AuthenticationServiceImpl service;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        User storedUser = service.register(registerRequest);
        return buildResponse(userMapper.toDto(storedUser), HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
//        return buildResponse(service.authenticate(request), HttpStatus.OK);
    }


}
