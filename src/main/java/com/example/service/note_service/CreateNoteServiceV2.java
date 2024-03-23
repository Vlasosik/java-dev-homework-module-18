//package com.example.service.note_service;
//
//import com.example.entity.NoteEntity;
//import com.example.entity.UserEntity;
//import com.example.repository.NoteRepository;
//import com.example.service.note_service.request.NoteCreateRequest;
//import com.example.service.note_service.response.NoteCreateResponse;
//import com.example.service.note_service.validation.NoteValidationService;
//import com.example.service.user_service.UserService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.security.Principal;
//
//@Service
//@AllArgsConstructor
//public class CreateNoteServiceV2 {
//    private final UserService userService;
//    private final NoteRepository noteRepository;
//    private final NoteValidationService noteValidationService;
//
//
//    public NoteCreateResponse noteCreate(Principal principal, NoteCreateRequest noteRequest) {
//        if (principal == null) {
//            return NoteCreateResponse.failed("User not authenticated!");
//        }
//        String loginName = principal.getName();
//        if (noteValidationService.isTitleAndContextValid(noteRequest.getTitle(), noteRequest.getContext())) {
//            return NoteCreateResponse.failed("Title or context cannot be empty or have less than 3 characters!");
//        }
//        UserEntity user = userService.findByUsername(loginName);
//        if (user == null) {
//            return NoteCreateResponse.failed("User not found!");
//        }
//        NoteEntity note = createNote(noteRequest, user);
//        return NoteCreateResponse.success(note.getId());
//    }
//
//    private NoteEntity createNote(NoteCreateRequest noteRequest, UserEntity user) {
//        NoteEntity note = new NoteEntity();
//        note.setContext(noteRequest.getContext());
//        note.setTitle(noteRequest.getTitle());
//        note.setUserEntity(user);
//        return noteRepository.save(note);
//    }
//}
//
//
