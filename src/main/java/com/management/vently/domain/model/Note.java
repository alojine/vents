package com.management.vently.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "note")
public class Note {

    @GeneratedValue
    @Id
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, name = "title")
    private String Title;

    @Column(nullable = false, name = "content")
    private String Content;

    @Column(nullable = false, name = "created_at")
    private Timestamp CreatedAt;

    @Column(nullable = false, name = "updated_at")
    private Timestamp UpdatedAt;
}
