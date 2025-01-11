package com.ticket.ticket_backend.entities.combine;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SlotSeatCompositeKey {

    @Column(name = "slot_id", nullable = false)
    Long slotId;

    @Column(name = "seat_id", nullable = false)
    Long seatId;

}
