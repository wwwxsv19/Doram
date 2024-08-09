package bssm.devcoop.domain.auth.presentation;

import bssm.devcoop.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final UserService userService;

//    @PostMapping("/signup")
//    public ResponseEntity<?> signUp(@RequestBody AUthDto.SignUpRequest request) {
//
//    }
}
