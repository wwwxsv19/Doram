package bssm.devcoop.domain.auth.presentation.dto;

import lombok.Getter;

import java.time.LocalDate;

public class AuthDto {
    @Getter
    public static class SignUpRequest {
        private String userId;
        private String userName;
        private String userEmail;
        private LocalDate userBirth;
        private String userPassword;
    }
}
