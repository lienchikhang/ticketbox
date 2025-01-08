package com.ticket.ticket_backend.entities;

import com.ticket.ticket_backend.enums.PermissionEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "permission_001")
@Data
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Permission {

    @Id
    @Column(name = "permission_name", columnDefinition = "varchar(100)", nullable = false)
    PermissionEnum permissionName;

    @Column(name = "permission_desc")
    String permissionDesc;
}
