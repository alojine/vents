package com.management.vently.controller;

import com.management.vently.mapper.EventMapper;
import com.management.vently.mapper.entity.EventDTO;
import com.management.vently.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/events")
public class EventController {

    private final EventService eventService;

    private final EventMapper eventMapper;

    @Autowired
    public EventController(EventService eventService, EventMapper eventMapper) {
        this.eventService = eventService;
        this.eventMapper = eventMapper;
    }

    @GetMapping
    public ResponseEntity<List<EventDTO>> getAll() {
        return new ResponseEntity<>(eventMapper.eventListToEventDTOList(eventService.getAll()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> save(@RequestBody EventDTO eventDTO) {
        eventService.save(eventMapper.eventDTOtoEvent(eventDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> put(@RequestBody EventDTO eventDTO) {
        eventService.put(eventMapper.eventDTOtoEvent(eventDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
