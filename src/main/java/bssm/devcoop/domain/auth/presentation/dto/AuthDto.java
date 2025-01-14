package bssm.devcoop.domain.auth.presentation.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

public class AuthDto {
    @Getter
    public static class SignUpRequest {
        private String userId;
        private String userName;
        private String userEmail;
        private String userPassword;
    }

    @Builder
    @Getter
    public static class SignUpResponse {
        private String message;
    }
}
