package com.ticket.ticket_backend.entities;

import com.ticket.ticket_backend.entities.combine.SharedEntity;
import com.ticket.ticket_backend.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "role_001")
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class Role {

    @Id
    @Column(name = "role_name", columnDefinition = "varchar(20)", nullable = false)
    @Enumerated(EnumType.STRING)
    RoleEnum roleName;

    @Column(name = "role_desc")
    String roleDesc;

    @Embedded
    SharedEntity shared;
}
