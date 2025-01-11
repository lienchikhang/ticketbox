package com.ticket.ticket_backend.services.impl;

import com.ticket.ticket_backend.dto.common.ListRes;
import com.ticket.ticket_backend.dto.request.create.RoleCreateReq;
import com.ticket.ticket_backend.dto.request.update.RoleUpdateReq;
import com.ticket.ticket_backend.dto.response.RoleRes;
import com.ticket.ticket_backend.entities.Role;
import com.ticket.ticket_backend.enums.ErrorCode;
import com.ticket.ticket_backend.enums.RoleEnum;
import com.ticket.ticket_backend.exception.AppException;
import com.ticket.ticket_backend.mappers.RoleMapper;
import com.ticket.ticket_backend.repositories.RoleRepository;
import com.ticket.ticket_backend.services.RoleService;
import com.ticket.ticket_backend.specifications.RoleSpecification;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleServiceImpl implements RoleService {

    //repo
    RoleRepository roleRepository;

    //mapper
    RoleMapper roleMapper;

    @Override
    public RoleRes createRole(RoleCreateReq req) throws IllegalArgumentException {

        Role newRole = roleMapper.toRole(req);
        newRole.setRoleName(RoleEnum.valueOf(req.getRoleName()));

        return roleMapper.toRes(roleRepository.save(newRole));
    }

    @Override
    public RoleRes getRoleByName(RoleEnum name) {
        return roleMapper.toRes(roleRepository.findById(name)
                .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND)));
    }

    @Override
    @Transactional
    public RoleRes updateRole(String name, RoleUpdateReq req) {

        log.info("in func update {}", name);

        //check existed role
        Role existedRole = roleRepository.findById(RoleEnum.valueOf(name)).orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));

        //check update
        if (Objects.nonNull(req.getRoleName())) {
            existedRole.setRoleName(RoleEnum.valueOf(req.getRoleName()));
        }

        if (Objects.nonNull(req.getRoleDesc())) {
            existedRole.setRoleDesc(req.getRoleDesc());
        }

        //save & return
        return roleMapper.toRes(roleRepository.save(existedRole));

    }

    //admin
    @Override
    public ListRes<RoleRes> getAllRoles(Pageable pageable) {

        //create spec
        Specification<Role> roleSpec = Specification
                .where(RoleSpecification.isDeleted(false));

        //get all roles
        List<RoleRes> roles = roleRepository.findAll(roleSpec).stream()
                .map((role) -> roleMapper.toRes(role)).toList();

        //get total
        Long itemCount = roleRepository.count(roleSpec);

        return ListRes.<RoleRes>builder()
                .currentPage(pageable.getPageNumber() + 1)
                .pageSize(pageable.getPageSize())
                .totalItem(itemCount)
                .data(roles)
                .build();
    }

    //admin
    @Override
    @Transactional
    public Void deleteRole(RoleEnum name) {
        //check existed role
        Role existedRole = roleRepository.findById(name).orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));
        existedRole.getShared().setIsDeleted(true);
        roleRepository.save(existedRole);
        return null;
    }
}
