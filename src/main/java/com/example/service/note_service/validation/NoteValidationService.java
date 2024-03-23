package com.example.service.note_service.validation;

import com.example.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class NoteValidationService {
    private final NoteRepository noteRepository;

    public boolean isTitleAndContextValid(String title, String context) {
        if (title == null || title.strip().length() <= 3) {
            return true;
        }
        if (context == null || context.strip().length() <= 3) {
            return true;
        }
        return false;
    }

    public boolean isNoteExist(Long id) {
        return noteRepository.findAllById(id).isPresent();
    }
}
