package com.management.vently.mapper;

import com.management.vently.mapper.entity.EventDTO;
import com.management.vently.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "location", source = "dto.location")
    @Mapping(target = "ticket", source = "dto.ticket")
    @Mapping(target = "date", source = "dto.date")
    @Mapping(target = "eventType", source = "dto.eventType")
    Event eventDTOtoEvent(EventDTO dto);

    @Mapping(target = "name", source = "entity.name")
    @Mapping(target = "location", source = "entity.location")
    @Mapping(target = "ticket", source = "entity.ticket")
    @Mapping(target = "date", source = "entity.date")
    @Mapping(target = "eventType", source = "entity.eventType")
    EventDTO eventToEventDTO(Event entity);

    List<EventDTO> eventListToEventDTOList(List<Event> events);
}
