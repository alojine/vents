package com.management.vently.mapper;

import com.management.vently.domain.DTO.NoteDTO;
import com.management.vently.domain.model.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    @Mapping(target = "title", source = "dto.title")
    @Mapping(target = "content", source = "dto.content")
    Note noteDTOToNote(NoteDTO dto);

    @Mapping(target = "title", source = "entity.title")
    @Mapping(target = "content", source = "entity.content")
    NoteDTO noteToNoteDTO(Note entity);

    List<NoteDTO> noteListToNoteDTOList(List<Note> notes);
}
