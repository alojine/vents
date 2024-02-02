package com.management.vently.service;

import com.management.vently.domain.model.Note;

import java.util.List;

public interface NoteService {

    List<Note> getNotesByUserId(Long userId);

    Note getById(Long id);

    Note add(Note note, Long userId);

    Note update(Note note, Long userId);

    void delete(Long id);
}
