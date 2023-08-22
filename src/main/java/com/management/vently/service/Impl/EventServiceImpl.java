package com.management.vently.service.Impl;

import com.management.vently.enums.VentlyError;
import com.management.vently.exception.VentlyUserNotFoundException;
import com.management.vently.model.Event;
import com.management.vently.model.User;
import com.management.vently.repository.EventRepository;
import com.management.vently.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getAllByUser (User user) {
        return eventRepository.findAllByUser(user)
                .orElseThrow(() -> new VentlyUserNotFoundException(VentlyError.NO_EVENT_FOUND + " " + VentlyError.INVALID_USER));
    }

    @Override
    public Event save(Event event, User user) {
        event.setUser(user);
        return eventRepository.save(event);
    }

    @Override
    public Event put(Event event) {
        Event updatedEvent = eventRepository.getReferenceById(event.getId());
        updatedEvent.setName(event.getName());
        updatedEvent.setLocation(event.getLocation());
        updatedEvent.setTicket(event.getTicket());
        updatedEvent.setDate(event.getDate());
        updatedEvent.setType(event.getType());

        return eventRepository.save(updatedEvent);
    }
}
