package com.mobuli.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or another suitable strategy
    @Column(name = "user_id", nullable = false)
    private long id;

    @Column(name = "username", nullable = false, length = 255)
    private String userName;

    @Column(name = "email", nullable = false) // TEXT in MySQL has a maximum length of 65535 characters
    private String emailAddress;

    @Column(name = "password_hash", nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName; // Changed to String to match your initial structure, otherwise use Integer or a Date type

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password_expire_date")
    private Date passwordExpireDate;

    @Column(name = "is_locked")
    private boolean isLocked;

    @Column(name = "account_created_at")
    private String accountCreatedAt;

    @Column(name = "password_updated_at")
    private String passwordUpdatedAt;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

}
