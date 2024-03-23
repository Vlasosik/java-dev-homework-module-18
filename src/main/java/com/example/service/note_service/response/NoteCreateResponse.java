package com.example.service.note_service.response;

import com.example.service.note_service.response.enum_status_code.StatusCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteCreateResponse {
    private long id;
    private boolean success;
    private StatusCode statusCode;
    private String message;

    public static NoteCreateResponse success(Long id) {
        return NoteCreateResponse.builder()
                .id(id)
                .success(true)
                .statusCode(StatusCode.CREATED)
                .message("Note successfully created!")
                .build();
    }

    public static NoteCreateResponse failed(String message) {
        return NoteCreateResponse.builder()
                .id(-1L)
                .success(false)
                .statusCode(StatusCode.BAD_REQUEST)
                .message(message)
                .build();
    }
}
