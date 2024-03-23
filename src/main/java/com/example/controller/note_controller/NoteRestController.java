package com.example.controller.note_controller;

import com.example.entity.NoteEntity;
import com.example.repository.NoteRepository;
import com.example.service.note_service.NoteCreateService;
import com.example.service.note_service.NoteDeleteService;
import com.example.service.note_service.NoteReadService;
import com.example.service.note_service.NoteUpdateService;
import com.example.service.note_service.request.NoteCreateRequest;
import com.example.service.note_service.request.NoteUpdateRequest;
import com.example.service.note_service.response.NoteCreateResponse;
import com.example.service.note_service.response.NoteDeleteResponse;
import com.example.service.note_service.response.NoteReadResponse;
import com.example.service.note_service.response.NoteUpdateResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/note")
@AllArgsConstructor
public class NoteRestController {
    private final NoteCreateService createNoteService;
    private final NoteReadService readNoteService;
    private final NoteUpdateService noteUpdateService;
    private final NoteDeleteService noteDeleteService;
    private final NoteRepository noteRepository;

    @GetMapping("/list")
    public List<NoteEntity> noteList() {
        return noteRepository.findAll();
    }


    @PostMapping("/create")
    public NoteCreateResponse createNote(@RequestBody NoteCreateRequest noteRequest) {
        return createNoteService.noteCreate(noteRequest);
    }

    @GetMapping("/read")
    public NoteReadResponse readNote(@RequestParam Long id) {
        return readNoteService.noteRead(id);
    }

    @PutMapping("/update")
    public NoteUpdateResponse updateNote(@RequestParam("id") Long id, @RequestBody NoteUpdateRequest noteUpdateRequest) {
        return noteUpdateService.updateNote(id, noteUpdateRequest);
    }

    @DeleteMapping("/delete")
    public NoteDeleteResponse noteDelete(@RequestParam Long id) {
        return noteDeleteService.noteDelete(id);
    }
}
