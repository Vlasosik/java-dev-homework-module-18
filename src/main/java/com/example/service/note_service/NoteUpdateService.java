package com.example.service.note_service;

import com.example.entity.NoteEntity;
import com.example.repository.NoteRepository;
import com.example.service.note_service.request.NoteUpdateRequest;
import com.example.service.note_service.response.NoteUpdateResponse;
import com.example.service.note_service.validation.NoteValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class NoteUpdateService {
    private final NoteRepository noteRepository;
    private final NoteValidationService noteValidationService;


    public NoteUpdateResponse updateNote(Long id, NoteUpdateRequest noteUpdateRequest) {
        if (noteValidationService.isTitleAndContextValid(noteUpdateRequest.getTitle(), noteUpdateRequest.getContext())) {
            return NoteUpdateResponse.failed("Note for {id: " + id + "} could not be update!");
        }
        NoteEntity note = getUpdateNote(id, noteUpdateRequest);
        return NoteUpdateResponse.success(note.getId());
    }

    private NoteEntity getUpdateNote(Long id, NoteUpdateRequest noteUpdateRequest) {
        NoteEntity note = noteRepository.findById(id).orElseThrow(NoSuchElementException::new);
        note.setTitle(noteUpdateRequest.getTitle());
        note.setContext(noteUpdateRequest.getContext());
        noteRepository.save(note);
        return note;
    }

}
