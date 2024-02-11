package com.management.vently.controller;

import com.management.vently.domain.DTO.NoteDTO;
import com.management.vently.mapper.NoteMapper;
import com.management.vently.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    private final NoteService noteService;

    private final NoteMapper noteMapper;

    @Autowired
    public NoteController(NoteService noteService, NoteMapper noteMapper) {
        this.noteService = noteService;
        this.noteMapper = noteMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDTO> getNoteById(@PathVariable Long id){
        return new ResponseEntity<>(noteMapper.noteToNoteDTO(noteService.getById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createNote(@RequestBody NoteDTO noteDTO){
        noteService.add(noteMapper.noteDTOToNote(noteDTO), noteDTO.userId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateNote(@RequestBody NoteDTO noteDTO){
        noteService.update(noteMapper.noteDTOToNote(noteDTO), noteDTO.userId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteNote(@PathVariable Long id) {
        noteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
