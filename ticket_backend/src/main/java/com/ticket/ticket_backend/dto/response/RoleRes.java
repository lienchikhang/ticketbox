package com.ticket.ticket_backend.dto.response;

import com.ticket.ticket_backend.enums.RoleEnum;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleRes {
    RoleEnum roleName;
    String roleDesc;
}
