package com.ticket.ticket_backend.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;

import java.math.BigDecimal;

@Entity
@Table(name = "ticket_seat_001")
@Data
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@DynamicInsert
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "original_price", nullable = false)
    BigDecimal originalPrice;

    @Column(name = "sale_price")
    BigDecimal salePrice;
}
