package com.ticket.ticket_backend.services.impl;

import com.ticket.ticket_backend.dto.common.ListRes;
import com.ticket.ticket_backend.dto.request.create.PermissionCreateReq;
import com.ticket.ticket_backend.dto.request.update.PermissionUpdateReq;
import com.ticket.ticket_backend.dto.response.PermissionRes;
import com.ticket.ticket_backend.entities.Permission;
import com.ticket.ticket_backend.enums.ErrorCode;
import com.ticket.ticket_backend.enums.PermissionEnum;
import com.ticket.ticket_backend.exception.AppException;
import com.ticket.ticket_backend.mappers.PermissionMapper;
import com.ticket.ticket_backend.repositories.PermissionRepository;
import com.ticket.ticket_backend.services.PermissionService;
import com.ticket.ticket_backend.specifications.PermissionSpecification;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionServiceImpl implements PermissionService {

    //repo
    PermissionRepository permissionRepository;

    //mapper
    PermissionMapper permissionMapper;

    @Override
    public PermissionRes createPermission(PermissionCreateReq req) {

        log.info("in create func {}", req.getPermissionName());

        Permission newPermission = permissionMapper.toPermission(req);
        newPermission.setPermissionName(PermissionEnum.valueOf(req.getPermissionName()));

        log.info("after set new per desc {}", newPermission.getPermissionDesc());
        log.info("after set new per name {}", newPermission.getPermissionName());

        return permissionMapper.toRes(permissionRepository.save(newPermission));
    }

    @Override
    public PermissionRes getPermissionByName(PermissionEnum name) {
        return permissionMapper.toRes(permissionRepository.findById(name).orElseThrow(() -> new AppException(ErrorCode.PERMISSION_NOT_FOUND)));
    }

    @Override
    public PermissionRes updatePermission(String name, PermissionUpdateReq req) {

        //check exists
        Permission existedPermission = permissionRepository.findById(PermissionEnum.valueOf(name))
                .orElseThrow(() -> new AppException(ErrorCode.PERMISSION_NOT_FOUND));

        if (Objects.nonNull(req.getPermissionName())) {
            existedPermission.setPermissionName(PermissionEnum.valueOf(req.getPermissionName()));
        }

        if (Objects.nonNull(req.getPermissionDesc())) {
            existedPermission.setPermissionDesc(req.getPermissionDesc());
        }

        //save & return
        return permissionMapper.toRes(permissionRepository.save(existedPermission));
    }

    @Override
    public ListRes<PermissionRes> getAllPermissions(Pageable pageable) {
        //create spec
        Specification<Permission> perSpec = Specification
                .where(PermissionSpecification.isDeleted(false));

        //get all roles
        List<PermissionRes> pers = permissionRepository.findAll(perSpec).stream()
                .map((per) -> permissionMapper.toRes(per)).toList();

        //get total
        Long itemCount = permissionRepository.count(perSpec);

        return ListRes.<PermissionRes>builder()
                .currentPage(pageable.getPageNumber() + 1)
                .pageSize(pageable.getPageSize())
                .totalItem(itemCount)
                .data(pers)
                .build();
    }

    @Override
    public Void deletePermission(PermissionEnum name) {
        //check existed role
        Permission existedPermission = permissionRepository.findById(name).orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));
        existedPermission.getShared().setIsDeleted(true);
        permissionRepository.save(existedPermission);
        return null;
    }
}
