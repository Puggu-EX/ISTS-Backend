package dev.puggu.ists.service;

import dev.puggu.ists.controller.dto.request.UserLogin;
import dev.puggu.ists.controller.dto.request.UserRegister;
import dev.puggu.ists.controller.dto.response.GenericResponse;
import dev.puggu.ists.entity.Users.StandardUser;
import dev.puggu.ists.repository.StandardUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class StandardUserService {
    private final StandardUserRepository standardUserRepo;

    /**
     * Standard User register service
     * @param request UserRegister body
     * @return response entity
     */
    public ResponseEntity<?> register(UserRegister request) {
        if (standardUserRepo.existsByEmail(request.email())) {
            return GenericResponse.build(HttpStatus.BAD_REQUEST, "User with this email already exists");
        }

        StandardUser standardUser = new StandardUser();
        standardUser.setFirstName(request.first_name());
        standardUser.setLastName(request.last_name());
        standardUser.setEmail(request.email());
        standardUser.setPassword(request.password());

        standardUserRepo.save(standardUser);

        return GenericResponse.build(HttpStatus.OK, "Successfully created user");
    }

    /**
     * Standard User Login service
     * Ambiguity in errors is a measure against brute force attacks
     * @param request UserLogin body
     * @return response entity
     */
    public ResponseEntity<?> login(UserLogin request) {
        StandardUser standardUser = getUserByEmail(request.email());

        if (standardUser == null)
            return GenericResponse.build(HttpStatus.BAD_REQUEST, "Error: Incorrect email or password");

        String password = standardUser.getPassword();

        if (password.equals(request.password())) {
            return GenericResponse.build(HttpStatus.OK, "Successfully logged in");
        }

       return GenericResponse.build(HttpStatus.BAD_REQUEST, "Error: Incorrect email or password");
    }

    public StandardUser getUserByEmail(String email) {
        return standardUserRepo.findByEmail(email).orElse(null);
    }
}
