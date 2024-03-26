package com.example.controller.note_controller;

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
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping("/api/v1/notes")
@AllArgsConstructor
@Validated
public class NoteRestController {
    private final NoteCreateService createNoteService;
    private final NoteReadService readNoteService;
    private final NoteUpdateService noteUpdateService;
    private final NoteDeleteService noteDeleteService;

    @PostMapping("/creates")
    public NoteCreateResponse createNote(Principal principal, @RequestBody NoteCreateRequest noteRequest) {
        return createNoteService.noteCreate(principal, noteRequest);
    }

    @GetMapping("/reads")
    public NoteReadResponse readNote(Principal principal, @RequestParam @NotNull Long id) {
        return readNoteService.noteRead(principal, id);
    }

    @PutMapping("/updates")
    public NoteUpdateResponse updateNote(Principal principal, @RequestParam("id") @NotNull Long id, @RequestBody NoteUpdateRequest noteUpdateRequest) {
        return noteUpdateService.updateNote(principal, id, noteUpdateRequest);
    }

    @DeleteMapping("/deletes")
    public NoteDeleteResponse noteDelete(Principal principal, @RequestParam @NotNull Long id) {
        return noteDeleteService.noteDelete(principal, id);
    }
}
