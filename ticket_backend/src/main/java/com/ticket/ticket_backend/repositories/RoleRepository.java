package com.ticket.ticket_backend.repositories;

import com.ticket.ticket_backend.entities.Role;
import com.ticket.ticket_backend.enums.RoleEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, RoleEnum>, JpaSpecificationExecutor<Role> {
    Page<Role> findAll(Specification<Role> spec, Pageable pageable);
}
