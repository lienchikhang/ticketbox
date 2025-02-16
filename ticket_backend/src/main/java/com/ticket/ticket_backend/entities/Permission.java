package com.ticket.ticket_backend.entities;

import com.ticket.ticket_backend.entities.combine.SharedEntity;
import com.ticket.ticket_backend.enums.PermissionEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "permission_001")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Permission {

    @Id
    @Column(name = "permission_name", columnDefinition = "varchar(100)", nullable = false)
    @Enumerated(EnumType.STRING)
    PermissionEnum permissionName;

    @Column(name = "permission_desc")
    String permissionDesc;

    @Embedded
    SharedEntity shared;
}
