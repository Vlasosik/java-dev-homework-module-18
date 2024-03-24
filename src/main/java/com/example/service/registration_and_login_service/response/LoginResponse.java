package com.example.service.registration_and_login_service.response;

import com.example.service.registration_and_login_service.response.enum_error.ErrorMessage;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private boolean success;
    private ErrorMessage error;
    private String authToken;

    public static LoginResponse success(String authToken) {
        return builder().success(true).error(ErrorMessage.OK).authToken(authToken).build();
    }

    public static LoginResponse failed(ErrorMessage error) {
        return builder().error(error).build();
    }
}
