package kz.kelsingazin.bootcamp.services;

import kz.kelsingazin.bootcamp.models.entities.User;
import kz.kelsingazin.bootcamp.models.requests.AuthenticationRequest;
import kz.kelsingazin.bootcamp.models.requests.RegisterRequest;
import kz.kelsingazin.bootcamp.models.responses.AuthenticationResponse;

public interface AuthenticationService {

    User register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
