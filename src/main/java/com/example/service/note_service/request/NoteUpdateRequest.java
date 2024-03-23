package com.example.service.note_service.request;

import lombok.Data;

@Data
public class NoteUpdateRequest {
    private String title;
    private String context;
}
