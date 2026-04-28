package dev.puggu.ists.controller.v1;

import dev.puggu.ists.controller.dto.request.UserRegister;
import dev.puggu.ists.service.StandardUserService;
import dev.puggu.ists.service.TechnicianService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
    //    public final UserService userService; // Generic user services
    public final StandardUserService standardUserService;
    public final TechnicianService technicianService;

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRegister userRegisterRequest) {
        return standardUserService.register(userRegisterRequest);
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
