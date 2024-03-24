package com.example.service.note_service;

import com.example.repository.NoteRepository;
import com.example.service.note_service.response.NoteDeleteResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@AllArgsConstructor
public class NoteDeleteService {
    private final NoteRepository noteRepository;

    public NoteDeleteResponse noteDelete(Principal principal, Long id) {
        if (principal == null) {
            NoteDeleteResponse.failed("User not authenticated!");
        }
        if (!noteRepository.existsById(id)) {
            return NoteDeleteResponse.failed("Note by {id: " + id + " } does not exist!");
        }
        return checkForUserDelete(id);
    }

    private NoteDeleteResponse checkForUserDelete(Long id) {
        try {
            noteRepository.deleteById(id);
            return NoteDeleteResponse.success(id);
        } catch (Exception ex) {
            return NoteDeleteResponse.failed("Failed to delete note by {id: " + id + " }");
        }
    }
}
