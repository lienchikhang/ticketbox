package com.ticket.ticket_backend.mappers;

import com.ticket.ticket_backend.dto.request.create.RoleCreateReq;
import com.ticket.ticket_backend.dto.response.RoleRes;
import com.ticket.ticket_backend.entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mappings({
            @Mapping(target = "roleName", ignore = true)
    })
    public Role toRole(RoleCreateReq req);

    RoleRes toRes(Role role);

}
