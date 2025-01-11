package com.ticket.ticket_backend.entities.combine;

import com.ticket.ticket_backend.entities.Permission;
import com.ticket.ticket_backend.entities.Role;
import com.ticket.ticket_backend.enums.PermissionEnum;
import com.ticket.ticket_backend.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Embeddable
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RolePerCompositeKey {

    @Column(name = "role_id")
    RoleEnum roleId;

    @Column(name = "per_id")
    PermissionEnum perId;

}
