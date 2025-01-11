package com.ticket.ticket_backend.dto.request.update;

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
public class RoleUpdateReq {

    @Length(max = 10, message = "INVALID_ROLE")
    RoleEnum roleName;

    String roleDesc;
}
