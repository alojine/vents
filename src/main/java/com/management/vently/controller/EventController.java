package com.management.vently.controller;

import com.management.vently.mapper.EventMapper;
import com.management.vently.mapper.entity.EventDTO;
import com.management.vently.mapper.entity.UserDTO;
import com.management.vently.model.User;
import com.management.vently.service.EventService;
import com.management.vently.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/events")
public class EventController {

    private final EventService eventService;

    private final UserService userService;

    private final EventMapper eventMapper;

    @Autowired
    public EventController(EventService eventService, UserService userService, EventMapper eventMapper) {
        this.eventService = eventService;
        this.userService = userService;
        this.eventMapper = eventMapper;
    }

    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllByUser(@RequestBody UserDTO userDTO) {
        User user = userService.getByEmail(userDTO.email());
        return new ResponseEntity<>(eventMapper.eventListToEventDTOList(eventService.getAllByUser(user)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> save(@RequestBody EventDTO eventDTO) {
        eventService.save(eventMapper.eventDTOtoEvent(eventDTO), userService.getByEmail(eventDTO.user().getEmail()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> put(@RequestBody EventDTO eventDTO) {
        eventService.put(eventMapper.eventDTOtoEvent(eventDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
