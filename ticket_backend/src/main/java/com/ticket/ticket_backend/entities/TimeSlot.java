package com.ticket.ticket_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "time_slot_001")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "slot")
    LocalDateTime slot;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    Ticket ticket;
}
