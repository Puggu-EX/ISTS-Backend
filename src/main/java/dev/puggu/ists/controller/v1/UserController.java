package dev.puggu.ists.controller.v1;

import dev.puggu.ists.controller.dto.request.UserLogin;
import dev.puggu.ists.controller.dto.request.UserRegister;
import dev.puggu.ists.service.StandardUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/users")
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
    public final StandardUserService standardUserService;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody UserRegister userRegisterRequest) {
        return standardUserService.register(userRegisterRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<?> createUser(@RequestBody UserLogin userLoginRequest) {
        return standardUserService.login(userLoginRequest);
    }


}
