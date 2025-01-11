package com.ticket.ticket_backend.controllers;

import com.ticket.ticket_backend.dto.common.ApiRes;
import com.ticket.ticket_backend.dto.common.ListRes;
import com.ticket.ticket_backend.dto.request.create.RoleCreateReq;
import com.ticket.ticket_backend.dto.request.update.RoleUpdateReq;
import com.ticket.ticket_backend.dto.response.RoleRes;
import com.ticket.ticket_backend.enums.RoleEnum;
import com.ticket.ticket_backend.services.RoleService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {

    //services
    RoleService roleService;

    @PostMapping("/create")
    public ApiRes<RoleRes> createRole(@RequestBody @Valid RoleCreateReq req) {
        return ApiRes.<RoleRes>builder()
                .statusCode(201)
                .metadata(roleService.createRole(req))
                .msg("Create successfully")
                .build();
    }

    @DeleteMapping("/delete/{name}")
    public ApiRes<Void> deleteRole(
            @PathVariable(name = "name") RoleEnum name
    ) {
        return ApiRes.<Void>builder()
                .statusCode(201)
                .metadata(roleService.deleteRole(name))
                .msg("Delete successfully")
                .build();
    }

    @DeleteMapping("/update/{name}")
    public ApiRes<RoleRes> updateRole(
            @PathVariable(name = "name") RoleEnum name,
            @RequestBody @Valid RoleUpdateReq req
            ) {
        return ApiRes.<RoleRes>builder()
                .statusCode(200)
                .metadata(roleService.updateRole(name, req))
                .msg("Delete successfully")
                .build();
    }

    @GetMapping("/get-by-name/{id}")
    public ApiRes<RoleRes> getRoleByName(
            @PathVariable(name = "id") RoleEnum name
    ) {
        return ApiRes.<RoleRes>builder()
                .msg("Get successfully")
                .statusCode(200)
                .metadata(roleService.getRoleByName(name))
                .build();
    }

    @GetMapping
    public ApiRes<ListRes<RoleRes>> getAllRole(
            @RequestParam(name = "page", defaultValue = "1", required = false) int page,
            @RequestParam(name = "pageSize", defaultValue = "12", required = false) int pageSize,
            @RequestParam(name = "direction", defaultValue = "asc", required = false) String direction
    ) {

        Sort sort = direction.equals("asc") ? Sort.by(Sort.Direction.ASC, "createdAt") : Sort.by(Sort.Direction.DESC, "createdAt");
        Pageable pageable = PageRequest.of(page - 1, pageSize, sort);

        return ApiRes.<ListRes<RoleRes>>builder()
                .statusCode(200)
                .metadata(roleService.getAllRoles(pageable))
                .msg("Get successfully")
                .build();
    }

}
