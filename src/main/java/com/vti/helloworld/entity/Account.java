package com.vti.helloworld.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private int accountId;
    private String email;
    private String userName;
    private String fullName;
    private Position position;
    private Department department;
}
