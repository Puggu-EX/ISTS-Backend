package dev.puggu.ists.service;

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
public class UserService {
    private final StandardUserRepository standardUserRepo;

    /**
     * Standard User register service
     * @param request UserRegister body
     * @return response entity
     */
    public ResponseEntity<?> register(UserRegister request) {
        // Validate unique email
        if (standardUserRepo.existsByEmail(request.email())) {
            return GenericResponse.build(HttpStatus.BAD_REQUEST, "User with this email already exists");
        }

        // Validate code to join org?
        /*
        String orgCode = GET_ORG_CODE;
        if (request.code() != orgCode){
            return GenericResponse.build(HttpStatus.BAD_REQUEST, "Invalid join code");
         }
         */

        StandardUser standardUser = new StandardUser();
        standardUser.setFirstName(request.first_name());
        standardUser.setLastName(request.last_name());
        standardUser.setEmail(request.email());
        standardUser.setPassword(request.password());

        standardUserRepo.save(standardUser);

        return GenericResponse.build(HttpStatus.OK, "Successfully created user");
    }

    public StandardUser getUserByEmail(String email) {
        return standardUserRepo.findByEmail(email).orElse(null);
    }
}
