package com.ticket.ticket_backend.repositories;

import com.ticket.ticket_backend.entities.Permission;
import com.ticket.ticket_backend.enums.PermissionEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, PermissionEnum>, JpaSpecificationExecutor<Permission> {
    public Page<Permission> findAll(Specification<Permission> spec, Pageable pageable);
}
