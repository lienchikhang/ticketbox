package com.ticket.ticket_backend.services;

import com.ticket.ticket_backend.dto.common.ListRes;
import com.ticket.ticket_backend.dto.request.create.PermissionCreateReq;
import com.ticket.ticket_backend.dto.request.update.PermissionUpdateReq;
import com.ticket.ticket_backend.dto.response.PermissionRes;
import com.ticket.ticket_backend.enums.PermissionEnum;
import org.springframework.data.domain.Pageable;

public interface PermissionService {

    PermissionRes createPermission(PermissionCreateReq req);

    PermissionRes getPermissionByName(PermissionEnum name);

    PermissionRes updatePermission(String name, PermissionUpdateReq req);

    ListRes<PermissionRes> getAllPermissions(Pageable pageable);

    Void deletePermission(PermissionEnum name);
}
