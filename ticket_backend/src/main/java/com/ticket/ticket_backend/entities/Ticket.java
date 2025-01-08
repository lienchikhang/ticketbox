package com.ticket.ticket_backend.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ticket_001")
@Data
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "ticket_name", columnDefinition = "varchar(255)", nullable = false)
    String ticketName;

    @Column(name = "img_url")
    String imgUrl;

    @Column(name = "start_at")
    LocalDateTime startAt;

    @Column(name = "end_at")
    LocalDateTime endAt;

    @Column(name = "location")
    String location;

    @Column(name = "description")
    String description;

    @Builder.Default
    @Column(name = "on_sale")
    Boolean onSale = false;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ticket")
    Organizer organizer;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<TimeSlot> slots;
}
