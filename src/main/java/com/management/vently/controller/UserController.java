package com.management.vently.controller;

import com.management.vently.domain.DTO.NoteDTO;
import com.management.vently.mapper.NoteMapper;
import com.management.vently.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final NoteService noteService;

    private final NoteMapper noteMapper;

    @Autowired
    public UserController(NoteService noteService, NoteMapper noteMapper) {
        this.noteService = noteService;
        this.noteMapper = noteMapper;
    }

    @GetMapping("/{id}/notes")
    public ResponseEntity<List<NoteDTO>> getAllUserNotes(@PathVariable Long id) {
        return new ResponseEntity<>(noteMapper.noteListToNoteDTOList(noteService.getNotesByUserId(id)), HttpStatus.OK);
    }
}
