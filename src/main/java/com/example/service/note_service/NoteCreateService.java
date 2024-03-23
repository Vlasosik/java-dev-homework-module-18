package com.example.service.note_service;

import com.example.entity.NoteEntity;
import com.example.repository.NoteRepository;
import com.example.service.note_service.request.NoteCreateRequest;
import com.example.service.note_service.response.NoteCreateResponse;
import com.example.service.note_service.validation.NoteValidationService;
import com.example.service.user_service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NoteCreateService {
    private final NoteRepository noteRepository;
    private final NoteValidationService noteValidationService;


    public NoteCreateResponse noteCreate(NoteCreateRequest noteRequest) {
        if (noteValidationService.isTitleAndContextValid(noteRequest.getTitle(), noteRequest.getContext())) {
            return NoteCreateResponse.failed("Title or context cannot be empty or have less than 3 characters!");
        }
        NoteEntity note = createNote(noteRequest);
        return NoteCreateResponse.success(note.getId());
    }

    private NoteEntity createNote(NoteCreateRequest noteRequest) {
        NoteEntity note = new NoteEntity();
        note.setContext(noteRequest.getContext());
        note.setTitle(noteRequest.getTitle());
        return noteRepository.save(note);
    }
}

