package com.example.service.note_service;

import com.example.entity.NoteEntity;
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
            return NoteDeleteResponse.failed("User not authenticated!");
        }
        if (!noteRepository.existsById(id)) {
            return NoteDeleteResponse.failed("Note by {id: " + id + " } does not exist!");
        }
        String username = principal.getName();
        NoteEntity note = noteRepository.findById(id).orElse(null);
        assert note != null;
        if (!note.getUserEntity().getLogin().equals(username)) {
            return NoteDeleteResponse.failed("Unauthorized access to the note!");
        }
        noteRepository.deleteById(id);
        return NoteDeleteResponse.success(id);
    }
}
