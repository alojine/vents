package com.management.vently.service;

import com.management.vently.model.Event;
import com.management.vently.model.User;

import java.util.List;

public interface EventService {
    List<Event> getAll();

    Event save(Event event, User user);

    Event put(Event event);

    List<Event> getAllByUser (User user);
}
