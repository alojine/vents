package com.management.vently.service.Impl;

import com.management.vently.domain.model.Note;
import com.management.vently.domain.model.User;
import com.management.vently.exception.NotFoundException;
import com.management.vently.repository.NoteRepository;
import com.management.vently.service.NoteService;
import com.management.vently.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    private final UserService userService;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository, UserService userService) {
        this.noteRepository = noteRepository;
        this.userService = userService;
    }

    @Override
    public Note getById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Note with Id: %s is not found", id)));
    }

    @Override
    public Note add(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note update(Note note) {
        return noteRepository.saveAndFlush(note);
    }

    @Override
    public void delete(Long id) {
        Note note = getById(id);
        noteRepository.delete(note);
    }

    @Override
    public List<Note> getNotesByUserId(Long userId) {
        return noteRepository.getNoteByUser(userService.getById(userId))
                .orElseThrow(() -> new NotFoundException(String.format("User with Id: %s has no notes", userId)));
    }
}
