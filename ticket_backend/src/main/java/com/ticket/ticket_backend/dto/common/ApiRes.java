package com.ticket.ticket_backend.dto.common;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiRes<T> {
    int statusCode;
    String msg;
    T metadata;
}
