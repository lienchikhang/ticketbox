package com.ticket.ticket_backend.specifications;

import com.ticket.ticket_backend.entities.Permission;
import com.ticket.ticket_backend.entities.Role;
import org.springframework.data.jpa.domain.Specification;

public class PermissionSpecification {

    public static Specification<Permission> isDeleted(Boolean isDeleted) {
        return ((root, query, criteriaBuilder) -> {
           if (!isDeleted) return criteriaBuilder.conjunction();
           return criteriaBuilder.equal(root.get("shared").get("isDeleted"), isDeleted);
        });
    }

}
