package com.example.service.note_service;

import com.example.entity.NoteEntity;
import com.example.repository.NoteRepository;
import com.example.service.note_service.response.NoteReadResponse;
import com.example.service.note_service.validation.NoteValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@AllArgsConstructor
public class NoteReadService {
    private final NoteRepository noteRepository;
    private final NoteValidationService noteValidationService;


    public NoteReadResponse noteRead(Principal principal, Long id) {
        if (principal == null) {
            return NoteReadResponse.failed("User not authentication!");
        }
        String username = principal.getName();
        if (!noteValidationService.isNoteExist(id)) {
            return NoteReadResponse.failed("Note by {" + id + "} does not exist!");
        }
        NoteEntity note = noteRepository.findById(id).orElse(null);
        if (note == null) {
            return NoteReadResponse.failed("Note by {" + id + "} not found!");
        }
        if (!note.getUserEntity().getLogin().equals(username)) {
            return NoteReadResponse.failed("Unauthorized access to the note!");
        }
        NoteReadResponse.Message message = getMessage(note);
        return NoteReadResponse.success(id, message);
    }

    private NoteReadResponse.Message getMessage(NoteEntity note) {
        String title = note.getTitle();
        String context = note.getContext();
        NoteReadResponse.Message message = new NoteReadResponse.Message();
        message.setTitle(title);
        message.setContext(context);
        return message;
    }
}
