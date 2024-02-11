package com.management.vently.controller;

import com.management.vently.domain.DTO.NoteDTO;
import com.management.vently.domain.DTO.PasswordDTO;
import com.management.vently.mapper.NoteMapper;
import com.management.vently.mapper.PasswordMapper;
import com.management.vently.service.NoteService;
import com.management.vently.service.PasswordService;
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

    private final PasswordService passwordService;

    private final NoteMapper noteMapper;

    private final PasswordMapper passwordMapper;

    @Autowired
    public UserController(NoteService noteService, PasswordService passwordService, NoteMapper noteMapper, PasswordMapper passwordMapper) {
        this.noteService = noteService;
        this.passwordService = passwordService;
        this.noteMapper = noteMapper;
        this.passwordMapper = passwordMapper;
    }

    @GetMapping("/{id}/notes")
    public ResponseEntity<List<NoteDTO>> getAllUserNotes(@PathVariable Long id) {
        return new ResponseEntity<>(noteMapper.noteListToNoteDTOList(noteService.getNotesByUserId(id)), HttpStatus.OK);
    }

    @GetMapping("/{id}/passwords")
    public ResponseEntity<List<PasswordDTO>> getAllUserPasswords(@PathVariable Long id) {
        return new ResponseEntity<>(passwordMapper.passwordListToPasswordDTOList(passwordService.getPasswordsByUserId(id)), HttpStatus.OK);
    }
}
