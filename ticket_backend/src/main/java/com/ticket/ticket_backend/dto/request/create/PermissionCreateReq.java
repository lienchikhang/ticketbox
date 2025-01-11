package com.ticket.ticket_backend.dto.request.create;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionCreateReq {
    @NotEmpty
    String permissionName;

    String permissionDesc;
}
