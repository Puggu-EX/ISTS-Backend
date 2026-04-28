package dev.puggu.ists.controller.v1;

import dev.puggu.ists.controller.dto.request.UserLogin;
import dev.puggu.ists.controller.dto.request.UserRegister;
import dev.puggu.ists.service.StandardUserService;
import dev.puggu.ists.service.TechnicianService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
public class AuthController {

    public final StandardUserService standardUserService;
    public final TechnicianService technicianService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLogin userLoginRequest) {
        return standardUserService.login(userLoginRequest);
    }

//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(@Valid @RequestBody UserLogin userLoginRequest) {
//        return standardUserService.login(userLoginRequest);
//    }
}
