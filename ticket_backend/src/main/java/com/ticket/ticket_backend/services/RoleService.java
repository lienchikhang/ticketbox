package com.ticket.ticket_backend.services;

import com.ticket.ticket_backend.dto.common.ListRes;
import com.ticket.ticket_backend.dto.request.create.RoleCreateReq;
import com.ticket.ticket_backend.dto.request.update.RoleUpdateReq;
import com.ticket.ticket_backend.dto.response.RoleRes;
import com.ticket.ticket_backend.enums.RoleEnum;
import org.springframework.data.domain.Pageable;

public interface RoleService {

    RoleRes createRole(RoleCreateReq req);

    RoleRes getRoleByName(RoleEnum name);

    RoleRes updateRole(RoleEnum name, RoleUpdateReq req);

    ListRes<RoleRes> getAllRoles(Pageable pageable);

    Void deleteRole(RoleEnum name);
}
