package com.ticket.ticket_backend.entities;

import com.ticket.ticket_backend.entities.combine.SlotSeatCompositeKey;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "slot_seat_001")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SlotSeat {

    @EmbeddedId
    SlotSeatCompositeKey id;

    @Column(name = "init_quantity", nullable = false)
    int initQuantity;

    @Column(name = "stock_quantity", nullable = false)
    int stockQuantity;

    @MapsId(value = "slotId")
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    TimeSlot slot;

    @MapsId(value = "seatId")
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    Seat seat;
}
