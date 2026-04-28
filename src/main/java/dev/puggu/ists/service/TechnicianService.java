package dev.puggu.ists.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class TechnicianService {
//    private final UserRepository userRepo;
//
//    public ResponseEntity<?> create(String firstName, String lastName, String email, String password) {
//        if (userRepo.existsByEmail(email)) {
//            return GenericResponse.build(HttpStatus.BAD_REQUEST, "User with this email already exists");
//        }
//
//        StandardUser standardUser = new StandardUser();
//        standardUser.setFirstName(firstName);
//        standardUser.setLastName(lastName);
//        standardUser.setEmail(email);
//        standardUser.setPassword(password);
//
//        userRepo.save(standardUser);
//
//        return GenericResponse.build(HttpStatus.OK, "Successfully created user");
//
//    }
//
//    public User getUser(UUID id){
//        Optional<User> optionalUser = userRepo.findById(id);
//        return optionalUser.orElse(null);
//    }
}
