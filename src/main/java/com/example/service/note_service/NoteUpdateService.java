package com.example.service.note_service;

import com.example.entity.NoteEntity;
import com.example.repository.NoteRepository;
import com.example.service.note_service.request.NoteUpdateRequest;
import com.example.service.note_service.response.NoteUpdateResponse;
import com.example.service.note_service.validation.NoteValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

@Service
@AllArgsConstructor
public class NoteUpdateService {
    private final NoteRepository noteRepository;
    private final NoteValidationService noteValidationService;

    @Transactional
    public NoteUpdateResponse updateNote(Principal principal, Long id, NoteUpdateRequest noteUpdateRequest) {
        if (principal == null) {
            return NoteUpdateResponse.failed("User not authentication!");
        }
        String username = principal.getName();
        if (noteValidationService.isTitleAndContextValid(noteUpdateRequest.getTitle(), noteUpdateRequest.getContext())) {
            return NoteUpdateResponse.failed("Note for {id: " + id + "} could not be update!");
        }
        NoteEntity note = noteRepository.findById(id).orElse(null);
        if (note == null) {
            return NoteUpdateResponse.failed("Note by {id: " + id + "} not found!");
        }
        if (!note.getUserEntity().getLogin().equals(username)) {
            return NoteUpdateResponse.failed("Unauthorized access to the note!");
        }
        getUpdateNote(noteUpdateRequest, note);
        noteRepository.save(note);
        return NoteUpdateResponse.success(note.getId());
    }

    private void getUpdateNote(NoteUpdateRequest noteUpdateRequest, NoteEntity note) {
        note.setTitle(noteUpdateRequest.getTitle());
        note.setContext(noteUpdateRequest.getContext());
    }
}
