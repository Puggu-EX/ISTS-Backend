package dev.puggu.ists.controller.v1;

import dev.puggu.ists.controller.dto.request.UserRegister;
import dev.puggu.ists.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
    public final UserService userService; // Generic user services

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRegister userRegisterRequest) {
        return userService.register(userRegisterRequest);
    }

//    @GetMapping
//    public ResponseEntity<?> getUser(@Valid @RequestBody UserRegister userRegisterRequest) {
//        return standardUserService.register(userRegisterRequest);
//    }

//    @PatchMapping
//    public ResponseEntity<?> updateUser(@Valid @RequestBody UserRegister userRegisterRequest) {
//        return standardUserService.register(userRegisterRequest);
//    }


}
