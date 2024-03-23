package com.example.service.note_service;

import com.example.repository.NoteRepository;
import com.example.service.note_service.response.NoteDeleteResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NoteDeleteService {
    private final NoteRepository noteRepository;

    public NoteDeleteResponse noteDelete(Long id) {
        if (!noteRepository.existsById(id)) {
            return NoteDeleteResponse.failed("Note by {id: " + id + " } does not exist!");
        }
        noteRepository.deleteById(id);
        return NoteDeleteResponse.success(id);
    }
}
