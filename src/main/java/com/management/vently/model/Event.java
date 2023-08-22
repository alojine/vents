package com.management.vently.model;

import com.management.vently.enums.EventType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100, name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "ticket")
    private Byte ticket;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EventType type;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

    @Column(nullable = false, name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;
}
