package bssm.devcoop.global.exception;

import bssm.devcoop.global.exception.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GlobalException extends Throwable {
    private final ErrorCode errorCode;
    private final String message;
}
