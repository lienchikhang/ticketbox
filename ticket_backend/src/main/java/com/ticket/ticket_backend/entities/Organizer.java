package com.ticket.ticket_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "organizer_001")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "organizer_name", columnDefinition = "varchar(100)")
    String organizerName;

    @Column(name = "img_url", columnDefinition = "varchar(100)")
    String imgUrl;

    @Column(name = "description", columnDefinition = "varchar(100)")
    String description;

    @OneToOne
    @JoinColumn(name = "organizer")
    Ticket ticket;
}
