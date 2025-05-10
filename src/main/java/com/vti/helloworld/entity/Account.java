package com.vti.helloworld.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FACEBOOK")
    private String facebook;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "AVATAR")
    private String avatar;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USER_TYPE")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "NOTE")
    private String note;

    public enum AccountStatus {
        ACTIVE, IN_ACTIVE,
        PENDING, BLOCK
    }

    public enum Role implements GrantedAuthority {
        ADMIN, USER;

        @Override
        public String getAuthority() {
            return name();
        }
    }
}
