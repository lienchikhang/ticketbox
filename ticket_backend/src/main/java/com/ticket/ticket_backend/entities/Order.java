package com.ticket.ticket_backend.entities;

import com.ticket.ticket_backend.entities.combine.SharedEntity;
import com.ticket.ticket_backend.enums.OrderEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "order_001")
@Data
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "quantity", nullable = false)
    int quantity;

    @Embedded
    SharedEntity shared;

    @Builder.Default
    @Column(name = "status")
    OrderEnum status = OrderEnum.UNPAID;

    @Builder.Default
    @Column(name = "is_over")
    boolean isOver = false;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    User user;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    Seat seat;
}
