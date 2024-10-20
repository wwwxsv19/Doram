package bssm.devcoop.global.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // 4xx
    BOOK_BAD_REQUEST(HttpStatus.BAD_REQUEST.value()),

    FORBIDDEN(HttpStatus.FORBIDDEN.value()),

    USER_NOT_FOUND(HttpStatus.NOT_FOUND.value()),

    CONFLICT(HttpStatus.CONFLICT.value()),

    USER_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value());

    private final int status;
}
