package dev.puggu.ists.service;

import dev.puggu.ists.controller.dto.request.UserLogin;
import dev.puggu.ists.controller.dto.request.UserRegister;
import dev.puggu.ists.controller.dto.response.GenericResponse;
import dev.puggu.ists.entity.Users.User;
import dev.puggu.ists.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepo;

    /**
     *  User register service
     * @param request UserRegister body
     * @return response entity
     */
    public ResponseEntity<?> register(UserRegister request) {
        // Validate unique email
        if (userRepo.existsByEmail(request.email())) {
            return GenericResponse.build(HttpStatus.BAD_REQUEST, "User with this email already exists");
        }

        // Validate code to join org?
        /*
        String orgCode = GET_ORG_CODE;
        if (request.code() != orgCode){
            return GenericResponse.build(HttpStatus.BAD_REQUEST, "Invalid join code");
         }
         */

        User User = new User();
        User.setFirstName(request.first_name());
        User.setLastName(request.last_name());
        User.setEmail(request.email());
        User.setPassword(request.password());
        User.setRole("ROLE_USER");

        userRepo.save(User);

        return GenericResponse.build(HttpStatus.OK, "Successfully created user");
    }

    public ResponseEntity<?> login(UserLogin request) {
        User standardUser = getUserByEmail(request.email());

        if (standardUser == null)
            return GenericResponse.build(HttpStatus.BAD_REQUEST, "Error: Incorrect email or password");

        String password = standardUser.getPassword();

        if (password.equals(request.password())) {
            return GenericResponse.build(HttpStatus.OK, "Successfully logged in");
        }

       return GenericResponse.build(HttpStatus.BAD_REQUEST, "Error: Incorrect email or password");
    }

    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email).orElse(null);
    }
}
