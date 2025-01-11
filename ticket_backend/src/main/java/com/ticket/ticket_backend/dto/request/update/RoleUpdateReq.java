package com.ticket.ticket_backend.dto.request.update;

import com.ticket.ticket_backend.enums.RoleEnum;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleUpdateReq {

    @Nullable
    @Size(max = 10, message = "INVALID_ROLE")
    String roleName;

    String roleDesc;
}
