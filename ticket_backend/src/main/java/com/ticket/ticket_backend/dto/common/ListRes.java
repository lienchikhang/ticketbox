package com.ticket.ticket_backend.dto.common;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ListRes<T> {
    int currentPage;
    int pageSize;
    Long totalItem;
    List<T> data;
}
