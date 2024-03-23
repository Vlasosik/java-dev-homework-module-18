package com.example.service.note_service.request;

import lombok.Data;

@Data
public class NoteCreateRequest {
    private String title;
    private String context;
}
