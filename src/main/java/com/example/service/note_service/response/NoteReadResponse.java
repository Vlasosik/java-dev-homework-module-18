package com.example.service.note_service.response;

import com.example.service.note_service.response.enum_status_code.StatusCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteReadResponse {
    private Long id;
    private boolean success;
    private StatusCode statusCode;
    private Message message;
    private String error;

    @Data
    public static class Message {
        private String title;
        private String context;
    }

    public static NoteReadResponse success(Long id, Message message) {
        return NoteReadResponse.builder()
                .id(id)
                .success(true)
                .statusCode(StatusCode.OK)
                .message(message)
                .build();
    }

    public static NoteReadResponse failed(String errorMessage) {
        return NoteReadResponse.builder()
                .id(-1L)
                .success(false)
                .statusCode(StatusCode.BAD_REQUEST)
                .error(errorMessage)
                .build();
    }
}

