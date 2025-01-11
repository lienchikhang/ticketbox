package com.ticket.ticket_backend.dto.response;

import com.ticket.ticket_backend.enums.PermissionEnum;
import com.ticket.ticket_backend.enums.RoleEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionRes {
    PermissionEnum permissionName;
    String permissionDesc;
}
