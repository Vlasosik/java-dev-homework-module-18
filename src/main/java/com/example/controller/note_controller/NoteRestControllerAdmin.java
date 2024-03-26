package com.example.controller.note_controller;

import com.example.entity.NoteEntity;
import com.example.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/notes/")
@RequiredArgsConstructor
public class NoteRestControllerAdmin {
    private final NoteRepository noteRepository;

    @GetMapping("/lists")
    public List<NoteEntity> noteList() {
        return noteRepository.findAll();
    }
}
