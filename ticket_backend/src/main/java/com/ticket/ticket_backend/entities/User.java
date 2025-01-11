package com.ticket.ticket_backend.entities;

import com.ticket.ticket_backend.entities.combine.SharedEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "user_001")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "email", columnDefinition = "varchar(255)", nullable = false)
    String email;

    @Column(name = "password", columnDefinition = "varchar(255)", nullable = false)
    String password;

    @Column(name = "first_name", columnDefinition = "varchar(255)")
    String firstName;

    @Column(name = "last_name", columnDefinition = "varchar(255)")
    String lastName;

    @Column(name = "phone", columnDefinition = "varchar(10)", nullable = false)
    String phone;

    @Column(name = "gender")
    int gender;

    @Column(name = "is_blocked", columnDefinition = "boolean default false")
    boolean isBlock;

    @Embedded
    SharedEntity shared;

    @ManyToOne
    @JoinColumn(name = "roleName")
    Role role;
}
