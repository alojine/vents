package com.management.vently.mapper;

import com.management.vently.mapper.entity.EventDTO;
import com.management.vently.model.Event;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EventMapper {
    List<EventDTO> eventListToEventDTO(List<Event> events);

    Event eventDTOtoevent(EventDTO eventDTO);
}
