package com.example.service.note_service.response;

import com.example.service.note_service.response.enum_status_code.StatusCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteUpdateResponse {
    private Long id;
    private boolean success;
    private StatusCode statusCode;
    private String message;

    public static NoteUpdateResponse success(Long id) {
        return NoteUpdateResponse.builder()
                .id(id)
                .success(true)
                .statusCode(StatusCode.OK)
                .message("Note successfully updated!")
                .build();
    }

    public static NoteUpdateResponse failed(String message) {
        return NoteUpdateResponse.builder()
                .id(-1L)
                .success(false)
                .statusCode(StatusCode.BAD_REQUEST)
                .message(message)
                .build();
    }
}
