package com.management.vently.service;

import com.management.vently.model.Event;

import java.util.List;

public interface EventService {
    List<Event> getAll();

    Event save(Event event);
}
