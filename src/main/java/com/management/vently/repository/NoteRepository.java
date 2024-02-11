package com.management.vently.repository;

import com.management.vently.domain.model.Note;
import com.management.vently.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    @Override
    Optional<Note> findById(Long id);

    Optional<Note> getNoteByTitleAndUser(String title, User user);

    Optional<List<Note>> getNotesByUser(User user);
}
