package com.management.vently.mapper.entity;

import com.management.vently.enums.EventType;

import java.time.LocalDate;

public record EventDTO(
        String name,
        String location,
        Byte ticket,
        LocalDate date,
        EventType eventType
) {
}
