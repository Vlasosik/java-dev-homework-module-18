package com.example.service.note_service.response;

import com.example.service.note_service.response.enum_status_code.StatusCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteDeleteResponse {
    private Long id;
    private boolean success;
    private StatusCode statusCode;
    private String message;

    public static NoteDeleteResponse success(Long id) {
        return NoteDeleteResponse.builder()
                .id(id)
                .success(true)
                .statusCode(StatusCode.OK)
                .message("Note successfully delete!")
                .build();
    }

    public static NoteDeleteResponse failed(String message) {
        return NoteDeleteResponse.builder()
                .id(-1L)
                .success(false)
                .statusCode(StatusCode.BAD_REQUEST)
                .message(message)
                .build();
    }
}
