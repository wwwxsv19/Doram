package bssm.devcoop.domain.auth.presentation;

import bssm.devcoop.domain.auth.presentation.dto.AuthDto;
import bssm.devcoop.entity.user.User;
import bssm.devcoop.domain.user.service.UserService;
import bssm.devcoop.entity.user.types.Role;
import bssm.devcoop.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/auth", produces = "application/json; charset=UTF8")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody AuthDto.SignUpRequest request) {
        log.info("Sign Up Started");

        String userId = request.getUserId();

        if (userService.isUserExistsById(userId)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("중복되는 유저 아이디입니다.");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(request.getUserPassword());

        User user = User.builder()
                .userId(userId)
                .userName(request.getUserName())
                .userEmail(request.getUserEmail())
                .userPassword(encodedPassword)
                .joinedAt(LocalDateTime.now())
                .roles(Role.ROLE_USER)
                .build();

        try {
            userService.saveUser(user);
            return ResponseEntity.ok().body("회원 가입이 완료되었습니다!");
        } catch (GlobalException e) {
            return ResponseEntity.status(e.getErrorCode().getStatus()).body(e.getMessage());
        }
    }
}
