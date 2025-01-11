package com.ticket.ticket_backend.dto.request.update;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionUpdateReq {
    String permissionName;
    String permissionDesc;
}
