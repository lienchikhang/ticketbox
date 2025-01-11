package com.ticket.ticket_backend.mappers;

import com.ticket.ticket_backend.dto.request.create.PermissionCreateReq;
import com.ticket.ticket_backend.dto.response.PermissionRes;
import com.ticket.ticket_backend.entities.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    @Mappings({
            @Mapping(target = "permissionName", ignore = true)
    })
    Permission toPermission(PermissionCreateReq req);

//    @Mappings({
//            @Mapping(target = "permissionName", ignore = true)
//    })
    PermissionRes toRes(Permission permission);

}
