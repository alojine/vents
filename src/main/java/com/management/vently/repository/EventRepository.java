package com.management.vently.repository;

import com.management.vently.model.Event;
import com.management.vently.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    Optional<List<Event>> findAllByUser(User user);
}
