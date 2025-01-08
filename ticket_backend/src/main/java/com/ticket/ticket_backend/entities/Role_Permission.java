package com.ticket.ticket_backend.entities;

import com.ticket.ticket_backend.entities.combine.RolePerCompositeKey;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "role_per_001")
@Data
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role_Permission {

    @EmbeddedId
    RolePerCompositeKey id;

    @ManyToOne
    @MapsId(value = "roleId")
    @JoinColumn(name = "roleName")
    Role role;

    @ManyToOne
    @JoinColumn(name = "permissionName")
    @MapsId(value = "perId")
    Permission permission;
}
