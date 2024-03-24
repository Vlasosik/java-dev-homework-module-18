package com.example.service.registration_and_login_service.response;

import com.example.service.registration_and_login_service.response.enum_error.ErrorMessage;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationResponse {
    private boolean success;
    private ErrorMessage error;

    public static RegistrationResponse success() {
        return builder().success(true).error(ErrorMessage.OK).build();
    }

    public static RegistrationResponse failed(ErrorMessage error) {
        return builder().success(false).error(error).build();
    }
}
