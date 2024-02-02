package com.management.vently.domain.DTO;

public record NoteDTO(
        String title,
        String content,
        Long userId
) {
}
