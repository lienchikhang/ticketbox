package com.ticket.ticket_backend.controllers;

import com.ticket.ticket_backend.dto.common.ApiRes;
import com.ticket.ticket_backend.dto.common.ListRes;
import com.ticket.ticket_backend.dto.request.create.PermissionCreateReq;
import com.ticket.ticket_backend.dto.request.create.RoleCreateReq;
import com.ticket.ticket_backend.dto.request.update.PermissionUpdateReq;
import com.ticket.ticket_backend.dto.request.update.RoleUpdateReq;
import com.ticket.ticket_backend.dto.response.PermissionRes;
import com.ticket.ticket_backend.dto.response.RoleRes;
import com.ticket.ticket_backend.enums.PermissionEnum;
import com.ticket.ticket_backend.enums.RoleEnum;
import com.ticket.ticket_backend.services.PermissionService;
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
@RequestMapping("/permissions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionController {

    //services
    PermissionService permissionService;

    @PostMapping("/create")
    public ApiRes<PermissionRes> createRole(@RequestBody @Valid PermissionCreateReq req) {
        return ApiRes.<PermissionRes>builder()
                .statusCode(201)
                .metadata(permissionService.createPermission(req))
                .msg("Create successfully")
                .build();
    }

    @DeleteMapping("/delete/{name}")
    public ApiRes<Void> deleteRole(
            @PathVariable(name = "name") PermissionEnum name
    ) {
        return ApiRes.<Void>builder()
                .statusCode(201)
                .metadata(permissionService.deletePermission(name))
                .msg("Delete successfully")
                .build();
    }

    @PatchMapping("/update/{name}")
    public ApiRes<PermissionRes> updateRole(
            @PathVariable(name = "name") String name,
            @RequestBody @Valid PermissionUpdateReq req
            ) {
        return ApiRes.<PermissionRes>builder()
                .statusCode(200)
                .metadata(permissionService.updatePermission(name, req))
                .msg("Update successfully")
                .build();
    }

    @GetMapping("/get-by-name/{id}")
    public ApiRes<PermissionRes> getRoleByName(
            @PathVariable(name = "id") PermissionEnum name
    ) {
        return ApiRes.<PermissionRes>builder()
                .msg("Get successfully")
                .statusCode(200)
                .metadata(permissionService.getPermissionByName(name))
                .build();
    }

    @GetMapping
    public ApiRes<ListRes<PermissionRes>> getAllRole(
            @RequestParam(name = "page", defaultValue = "1", required = false) int page,
            @RequestParam(name = "pageSize", defaultValue = "12", required = false) int pageSize,
            @RequestParam(name = "direction", defaultValue = "asc", required = false) String direction
    ) {

        Sort sort = direction.equals("asc") ? Sort.by(Sort.Direction.ASC, "createdAt") : Sort.by(Sort.Direction.DESC, "createdAt");
        Pageable pageable = PageRequest.of(page - 1, pageSize, sort);

        return ApiRes.<ListRes<PermissionRes>>builder()
                .statusCode(200)
                .metadata(permissionService.getAllPermissions(pageable))
                .msg("Get successfully")
                .build();
    }

}
